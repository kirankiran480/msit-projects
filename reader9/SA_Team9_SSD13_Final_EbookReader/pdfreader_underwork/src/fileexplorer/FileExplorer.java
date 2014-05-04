package fileexplorer;


import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.*;


@SuppressWarnings("serial")
public class FileExplorer extends JPanel{
	public JTree tree;	
	public DefaultMutableTreeNode root=new DefaultMutableTreeNode();
	public DefaultMutableTreeNode node;
	public PopupMenu pMenu=new PopupMenu();
	public GhostDragImg ghostImg=new GhostDragImg();
	
	public FileExplorer(File dir){
		node=new DefaultMutableTreeNode(dir);
		if(dir.isDirectory()&dir.listFiles()!=null)node.add(new DefaultMutableTreeNode(new File("**")));
		root.add(node);
		tree=new JTree(root);
		tree.setRootVisible(false);
		tree.setTransferHandler(new TransferHandler(){
            public int getSourceActions(JComponent c){
            	return COPY;
            }
            protected Transferable createTransferable(JComponent component){
                List<File> transFiles = new ArrayList<File>();
            	transFiles.add((File)node.getUserObject());
            	Transferable transferable=new GenericTransferable(transFiles);
                return transferable;
            }
            class GenericTransferable implements Transferable{
            	private List<File> transFfiles;
                public GenericTransferable(List<File> files){this.transFfiles=files;}
                public DataFlavor[] getTransferDataFlavors(){return new DataFlavor[]{DataFlavor.javaFileListFlavor};}
                public boolean isDataFlavorSupported(DataFlavor flavor){return flavor.equals(DataFlavor.javaFileListFlavor);}
                public Object getTransferData(DataFlavor flavor)throws UnsupportedFlavorException,IOException{return transFfiles;}
            }
        });
		tree.setDropTarget(new DropTarget(){
        	public void dragExit(DropTargetEvent arg0){
        		ghostImg.stop();
        		tree.repaint();
        		tree.setSelectionPath(null);
            }
            public void dragOver(DropTargetDragEvent dtde){
            	int action=dtde.getDropAction();
            	if(action==1)if(!ghostImg.isVisible())ghostImg.start(node);
            	tree.setSelectionPath(tree.getClosestPathForLocation((int)dtde.getLocation().getX(),(int)dtde.getLocation().getY()));
            }
            @SuppressWarnings("unchecked")
			public void drop(DropTargetDropEvent dtde){
            	ghostImg.stop();            	
            	int action=dtde.getDropAction();
                dtde.acceptDrop(action);    
                if(node.isNodeDescendant(((DefaultMutableTreeNode)tree.getLastSelectedPathComponent())))
                	return;
                try{
                	Transferable data=dtde.getTransferable();
                    if(data.isDataFlavorSupported(DataFlavor.javaFileListFlavor)){
                    	List<File> files=(List<File>)data.getTransferData(DataFlavor.javaFileListFlavor);
                    	DefaultTreeModel treeModel=(DefaultTreeModel)tree.getModel();
                        for (File file:files){
                        	String msg;                            
                            if(action==1)msg="Move : "+file.getName()+" to\n"+(MutableTreeNode)tree.getLastSelectedPathComponent();
                            else {msg="Copy : "+file.getName()+" to\n"+(MutableTreeNode)tree.getLastSelectedPathComponent();}
                            
                            if(JOptionPane.showConfirmDialog(null,msg,"Confirm Dialog",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
                                ExecutorService threadExecutor=Executors.newFixedThreadPool(1);
                                if(action==1){
                                	String str=node.toString();  
                                	str=str.substring(str.lastIndexOf("\\"),str.length());
                                    threadExecutor.execute(new CopyDialog((File)node.getUserObject(),new File(
                                      	  ((MutableTreeNode)tree.getLastSelectedPathComponent()).toString()+str),true));
                                    threadExecutor.shutdown();
                                	DefaultMutableTreeNode newNode=new DefaultMutableTreeNode(new File(
                                      	  ((MutableTreeNode)tree.getLastSelectedPathComponent()).toString()+str));
                                	if(node.getChildCount()!=0)newNode.add(new DefaultMutableTreeNode("**"));
                                	treeModel.insertNodeInto(newNode,(MutableTreeNode)tree.getLastSelectedPathComponent(),0);
                                	treeModel.removeNodeFromParent(node);
                                }else{
                                	threadExecutor.execute(new CopyDialog(file, new File(
                                			((MutableTreeNode)tree.getLastSelectedPathComponent()).toString()+"\\"+file.getName()),false));
                                	DefaultMutableTreeNode newNode=new DefaultMutableTreeNode(new File(
                                			((MutableTreeNode)tree.getLastSelectedPathComponent()).toString()+"\\"+file.getName()));
                                	if(file.isDirectory()){
                                		if(file.listFiles()!=null)newNode.add(new DefaultMutableTreeNode("**"));
                                		treeModel.insertNodeInto(newNode,(MutableTreeNode)tree.getLastSelectedPathComponent(),0);
                                	}
                                }
                                threadExecutor.shutdown();
                                tree.repaint();
                            }
                        }
                    }
            	} catch (Exception e){
            		e.printStackTrace();
            	}
            }
        });
		tree.addTreeWillExpandListener(new TreeWillExpandListener(){
			public void treeWillCollapse(TreeExpansionEvent evt)throws ExpandVetoException {
			}
			public void treeWillExpand(TreeExpansionEvent evt)throws ExpandVetoException {
				tree.setSelectionPath(evt.getPath());
				node=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				loadDir(node);
			}
			
		});
		tree.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent evt){
				node=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				loadDir(node);
				if(evt.getButton()==1&evt.getClickCount()==2)
					try {if(node!=null)if(((File)node.getUserObject()).isFile())Desktop.getDesktop().open((File)node.getUserObject());
					}catch(IOException e){JOptionPane.showMessageDialog(null,"Unable to read file","Reading Error",JOptionPane.OK_OPTION);}
				if(evt.getButton()==3)pMenu.show(tree, evt.getPoint(),
						(DefaultMutableTreeNode)tree.getLastSelectedPathComponent());
			}
		});
		tree.setDragEnabled(true);
		tree.setCellRenderer(new FileTreeCellRenderer());
		tree.setShowsRootHandles(true);
		setLayout(new GridLayout(1,0));
		add(new JScrollPane(tree));
	}
	private void loadDir(final DefaultMutableTreeNode node){
		if(node!=null){
			if(node.getChildCount()!=0){
	    		if(node.getChildAt(0).toString()=="**"){
	    			File parentFile=(File)node.getUserObject();
                    tree.setEnabled(false);
                    if(parentFile.isDirectory()){
                        File[] files=FileSystemView.getFileSystemView().getFiles(parentFile, true);
                        for(File childFile:files){
                        	if(childFile.isDirectory()){
                        		DefaultMutableTreeNode childNode=new DefaultMutableTreeNode(childFile);
                            	if(childFile.isDirectory()&childFile.listFiles()!=null&childFile.listFiles().length!=0)
                            		childNode.add(new DefaultMutableTreeNode("**"));
                            	node.add(childNode);
                        	}
                        }
                        for (File childFile:files)if(childFile.isFile())node.add(new DefaultMutableTreeNode(childFile));
                    }
                    node.remove(0);
                    tree.setEnabled(true);
	        	}
	    	}
		}
	}
        public static void main(String[] arg){
        JFrame frame=new JFrame();
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new FileExplorer(new File("C:/")));
        frame.setVisible(true);
    }
}
