package fileexplorer;

import java.awt.Component;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.*;

@SuppressWarnings("serial")
class FileTreeCellRenderer extends DefaultTreeCellRenderer {
    private FileSystemView fileSystemView;
    private JLabel label;

    FileTreeCellRenderer() {
        label=new JLabel();
        label.setOpaque(true);
        fileSystemView=FileSystemView.getFileSystemView();
    }
    public Component getTreeCellRendererComponent(JTree tree,Object value,boolean selected,
    		boolean expanded,boolean leaf,int row,boolean hasFocus) {

        DefaultMutableTreeNode node=(DefaultMutableTreeNode)value;
        if(node.toString()!="**"){
        	File file=(File)node.getUserObject();
        	label.setIcon(fileSystemView.getSystemIcon(file));
            label.setText(fileSystemView.getSystemDisplayName(file));

            if (selected) {
                label.setBackground(backgroundSelectionColor);
            } else {
                label.setBackground(backgroundNonSelectionColor);
            }
        }
        return label;
    }
}
