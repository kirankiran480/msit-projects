import java.util.ArrayList;


public class FeatureInstanceList 
{
	
	private ArrayList<FeatureInstance> instancelist;
	public ArrayList<FeatureInstance> list_of_inconsistent_instances;
	public ArrayList<FeatureInstance> list_of_consistent_instances;
	
	FeatureInstanceList()
	{
		instancelist=new ArrayList<FeatureInstance>();
		list_of_inconsistent_instances=new ArrayList<FeatureInstance>();
		list_of_consistent_instances=new ArrayList<FeatureInstance>();
	}
	
	
	FeatureInstanceList(FeatureList fl)
	{
		instancelist=new ArrayList<FeatureInstance>();
		FeatureInstance fi = null;
		for(int i=0;i<fl.getAllFeaturesArray().get(0).getFeatureArraySize();i++)
		{
			fi=new FeatureInstance(i,fl);
			instancelist.add(fi);
		}
	//	System.out.println("featureinstance"+fi.getInstanceFValues());
	}
	
	//method to get featureinstancelist
	
	public ArrayList<FeatureInstance> getFeatureInstanceList()
	{
		if(instancelist!=null)
		{
			return instancelist;
		}
		return null;
	}
	
	//method to get featureinstance list size
	
	public int getFeatureInstanceListSize()
	{
		if(instancelist!=null)
			return instancelist.size();
		return 0;
	}
	
	//method to get an instance
	public FeatureInstance getFeatureInstance(int i)
	{
		return instancelist.get(i);
	}
	
	//method to add an instance to instancelist
	public void addFeatureInstance(FeatureInstance fi)
	{
		if(instancelist==null)
			instancelist=new ArrayList<FeatureInstance>();
		instancelist.add(fi);
	}
	
	//method to remove an instance from the list
	public void removeFeatureInstance(FeatureInstance fi)
	{
		instancelist.remove(fi);
	}
	
	 //Method to get row numbers of specified instance in the FeatureInstance List.
    public ArrayList<Integer> getInstanceIndices(FeatureInstance inst) {
        ArrayList<Integer> instance_indices_array=new ArrayList<Integer>();
        for(int g=0; g<this.instancelist.size();g++){
            if(this.instancelist.get(g).isEqual(inst)){
                instance_indices_array.add(g);
            }
        }
        return instance_indices_array;
    }
    
    
    //Method to get row numbers of specified list of instance in the Instance List.
    public ArrayList<Integer> getIndicesofInstancelist(ArrayList<FeatureInstance> instlist) {
        ArrayList<Integer> instlist_rows=new ArrayList<Integer>();
        for (int n =0; n < instlist.size(); n++) {
                    FeatureInstance inst = instlist.get(n);
                    ArrayList<Integer> inst_rows;
                    inst_rows=this.getInstanceIndices(inst);
                    for(int p=0; p<inst_rows.size();p++){
                        instlist_rows.add(inst_rows.get(p));
                    }
            }
            return instlist_rows;
    }
	//method for finding inconsistent instances
	 
    public FeatureInstanceList findInconsistentInstanceList() {
        this.list_of_inconsistent_instances=new ArrayList<FeatureInstance>();
        this.list_of_consistent_instances=new ArrayList<FeatureInstance>();
        Tree data_instance_tree = new Tree(new Node("root"));
        int p = 0, q = 0, d = 0, n = 0, x;
        String str;
        Node<String> n1, n2;
        int length = this.getFeatureInstance(0).getInstanceFValues().size();
        for (x = 0; x < this.getFeatureInstanceListSize(); x++) {
            int y = 0;
            n2 = data_instance_tree.getRootElement();
            int g = 0;
            while (g < length) {
                str = this.getFeatureInstance(x).getInstanceFValues().get(g);
                n1 = new Node(str);
                int l = n2.getNumberOfChildren();
                int m = 0;
                while (m < l) {
                    if (n2.getChildren().get(m).getData().equals(n1.getData())) {
                        n2 = n2.getChildren().get(m);
                        y++;
                        break;
                    }
                    m++;
                }
                if (m == l) {
                    n2 = n2.addChild(n1);
                    n2 = n2.getChildren().get(m);
                    y++;
                }
                g++;
            }
            if (y == length) {
                str = this.getFeatureInstance(x).getInstanceTargetValue();
                n1 = new Node(str);
                if (n2.getNumberOfChildren() == 0) {
                    n2.addChild(n1);
                    n2.addChild(new Node(Integer.toString(x)));
                    n++;
                    this.list_of_consistent_instances.add(this.instancelist.get(x));
                    //If it comes here it is anew consistent path at this time in tree;
                    //System.out.println("Adding new leaf");
                } else if (n2.getNumberOfChildren() == 2) {
                    d++;
                    if (n2.getChildren().get(0).equals(n1)) {
                        p++;
                        // If it comes here it is already existing path in tree;
                    } else {
                        q++;
                        int z=Integer.parseInt(n2.getChildren().get(1).getData());
                        if(!this.list_of_inconsistent_instances.contains(this.instancelist.get(z))){
                            this.list_of_inconsistent_instances.add(this.instancelist.get(z));
                            this.list_of_consistent_instances.remove(this.instancelist.get(z));
                            //this.list_of_consistent_instances.remove(this.instance_list.get(x));
                        }
                        // If it comes here it is a conflicting with the existing path in tree;
                    }
                } 
            }
        }
        return this;
    }

}
