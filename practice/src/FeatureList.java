import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;


public class FeatureList {

	
	private ArrayList<Feature> feature_array;
	private Feature target;
	private double threshold;
	
	//default constructor
	public FeatureList()
	{
		feature_array=new ArrayList<Feature>();
		target=new Feature();
	}
	
	//constructor for creating list of features from training data
	public FeatureList(File trainingdata) throws IOException
	{
		if(feature_array==null)
		{
			feature_array=new ArrayList<Feature>();
		}
		if(target==null)
		{
			target=new Feature();
		}
		
		ArrayList<String> featurename=new ArrayList();
		String targetname=null;
		StringTokenizer tokens;
		BufferedReader br=new BufferedReader(new FileReader(trainingdata));
		String line;
		
		if((line=br.readLine())!=null)
		{
		   tokens=new StringTokenizer(line,",");
		   int n=tokens.countTokens();
		   for(int i=0;i<n-1;i++)
		   {
			   featurename.add(tokens.nextToken());
		   }
		   targetname=tokens.nextToken();
		}
		
		
		ArrayList<ArrayList<String>> featurelist=new ArrayList<ArrayList<String>>();
		for(int j=0;j<featurename.size()+1;j++)
		{
			featurelist.add(new ArrayList<String>());
		}
	//	System.out.println(featurename);
	//	System.out.println(targetname);
		while((line=br.readLine())!=null)
		{
		   tokens=new StringTokenizer(line,",");
		   for(int j=0;j<featurename.size()+1;j++)
			{
				featurelist.get(j).add(tokens.nextToken());
			}
		}
		System.out.println(featurelist);
		for (int k = 0; k < featurename.size(); k++) {
            feature_array.add(new Feature(featurename.get(k), featurelist.get(k)));
          //  System.out.println(feature_array.get(k).getFeatureArray());
          //  System.out.println(feature_array.get(k).getFeatureRange());
        }
        target = new Feature(targetname, featurelist.get(featurename.size()));

	}
	
	public FeatureList(ArrayList<Feature> farray,Feature targetvalue)
	{
		feature_array=farray;
		target=targetvalue;
		threshold=0;
	}
	
	public double setThreshold(double threshold1)
	{
		threshold=threshold1;
		return threshold;
	}
	
	public double getThreshold()
	{
		return threshold;
	}
	  //Method to remove duplicate features
    public FeatureList removeDuplicateFeatures() {
        Feature f1;
        Feature f2;
        int start = 0;
        while (start < feature_array.size()) {
            Iterator iter = this.feature_array.listIterator();
            for (int j = 0; j < start; j++) {
                iter.next();
            }
            f1 = (Feature) iter.next();
            while (iter.hasNext()) {
                f2 = (Feature) iter.next();
                if (f2.equals(f1)) {
                    iter.remove();
                }
            }
            start++;
        }
        /*
      for(int i=0;i<feature_array.size();i++)
      {
    	  System.out.println(feature_array.get(i).getFeatureArray());
      }*/
        return this;
    }

    //Method to add a feature
    public FeatureList addFeature(Feature f) {
        if (feature_array == null) {
        	feature_array = new ArrayList();
        }
        feature_array.add(f);
        return this;
    }
    
    //Method to add a feature at an index
    public FeatureList addFeature(int index,Feature f) {
        if (feature_array == null) {
        	feature_array = new ArrayList();
        }
        feature_array.add(index, f);
        return this;
    }
    
    //Method to get a feature by taking its name
    public Feature getFeature(String fname){
    	Feature f=new Feature();
        for(int v=0;v<this.feature_array.size();v++){
            if(fname.equals(this.feature_array.get(v).getName())){
                f=this.feature_array.get(v);
                break;
            }
        }
        return f;
    }
    
    
    //Method to remove feature by taking its name
    public FeatureList removeFeature(Feature f) {
        if (this.feature_array == null) {
            this.feature_array = new ArrayList();
        }
        this.feature_array.remove(f);
        return this;
    }
    
    //Method to remove a feature value at an index
    public FeatureList removeFeatureValueatIndex(int index) {
        if (feature_array != null)
            if(target!=null){
                for(int k=0; k<feature_array.size();k++)
                	feature_array.get(k).removeFeatureValue(index);
                target.removeFeatureValue(index);
            }

        return this;
    }
    
    //Method to remove feature by taking its name
    public FeatureList removeFeature(String fname) {
        if (feature_array == null) {
        	feature_array = new ArrayList();
        }
        for(int f=0; f<feature_array.size();f++){
            if(feature_array.get(f).getName().equals(fname)){
            	feature_array.remove(feature_array.get(f));
                break;
            }
        }
        return this;
    }

    //method to add target 
    public FeatureList addTarget(Feature f)
    {
		if(target==null)
		{
			target=new Feature();
			target=f;
		}
    	return this;
    	
    }
    
    //Method to get featurearray
    public ArrayList<Feature> getAllFeaturesArray()
    {
    	return feature_array;
    }
    
    //method to get target
    public Feature getTarget()
    {
    	return target;
    }
    
    //Method to sort the fetaures according to the range of feature values (no of diiferent feature values).
    public FeatureList sortFeatures() {
      //  Collections.sort(this.feature_array);
        return this;

    }
    
    //method to remove junk values
    public FeatureList removeJunk()
    {
    	Feature feature;
    	Iterator iterator=feature_array.listIterator();
    	while(iterator.hasNext())
    	{
    		feature=(Feature)iterator.next();
    		if((feature.getFeatureRangeSize()==1) || feature.getFeatureRangeSize()==feature.getFeatureArraySize())
    		{
    			iterator.remove();
    		}
    	}
    	
    	FeatureInstanceList fil=new FeatureInstanceList(this);
    	fil=fil.findInconsistentInstanceList();
    	
    	ArrayList<Integer> instance_indices_array;
    	FeatureInstance inst;
   	System.out.println("demo");
    	System.out.println(fil.list_of_inconsistent_instances.size());
        for (int h = fil.list_of_inconsistent_instances.size() - 1; h >= 0; h--) {
            inst = fil.list_of_inconsistent_instances.get(h);
            
            System.out.println("inconsistent"+inst.getInstanceFValues());
            instance_indices_array = fil.getInstanceIndices(inst);
            Collections.sort(instance_indices_array);
            for (int l = instance_indices_array.size() - 1; l >= 0; l--) {
                this.removeFeatureValueatIndex(instance_indices_array.get(l));
            }
            
        }
        System.out.println("consistent size"+fil.list_of_consistent_instances.size());
      //  System.out.println("consistent"+fil.list_of_consistent_instances.get(0).getInstanceFValues());
       // System.out.println("consistent"+fil.list_of_consistent_instances.get(1).getInstanceFValues());
      //  System.out.println("consistent"+fil.list_of_consistent_instances.get(2).getInstanceFValues());
       
        
      //  System.out.println(this.getAllFeaturesArray().get(0).getFeatureArray());
		return this;
    	
    }
    
    

    
    //method to find core features
    public FeatureList findCoreFeatures() {
    	FeatureList corefeatureslist = new FeatureList();
    	corefeatureslist=corefeatureslist.addTarget(target);
        Feature f = null;
      /*  System.out.println("core"+this.getAllFeaturesArray().size());
        System.out.println("core"+this.getAllFeaturesArray().get(0).getFeatureArray());
        System.out.println("core"+this.getAllFeaturesArray().get(1).getFeatureArray());
        System.out.println("core"+this.getAllFeaturesArray().get(2).getFeatureArray());
        System.out.println("core"+this.getAllFeaturesArray().get(3).getFeatureArray());
	*/
        for (int b = 0; b < feature_array.size(); b++) {
            f = feature_array.get(b);
         //   System.out.println(f.getFeatureArray());
            this.removeFeature(f);
            FeatureInstanceList instance_list  = new FeatureInstanceList(this);
            instance_list=instance_list.findInconsistentInstanceList();
       //     System.out.println("inconsistent size"+instance_list.list_of_inconsistent_instances.size());
            if(!instance_list.list_of_inconsistent_instances.isEmpty()){
            	corefeatureslist.addFeature(f);
            }
        //    System.out.println(this.getAllFeaturesArray().size());
            
            this.addFeature(b,f);
            }
       
        corefeatureslist.target=this.getTarget();
        System.out.println("core size"+corefeatureslist.getAllFeaturesArray().size());
     //   System.out.println("after core"+this.getAllFeaturesArray().get(0).getFeatureArray());

        return corefeatureslist;
    }
    
    
    
    //Method to find predominant attribute among the all available attributes
    public Feature findPredominantFeature(FeatureList fl1){
        if(this.feature_array==null)
            this.feature_array=new ArrayList<Feature>();
        if(this.target==null)
            this.target=new Feature();
        if(fl1.target==null){
            fl1.target=new Feature();
            fl1.target=this.target;
        }
        Feature atbt;
        int highest_consistences=0;
        Feature predominant_attribute=new Feature();
        fl1.target=this.getTarget();
        for (int g = this.getAllFeaturesArray().size() - 1; g >= 0; g--) {
            if (!fl1.feature_array.contains(this.feature_array.get(g))) {
                atbt = this.getAllFeaturesArray().get(g);
                fl1.getAllFeaturesArray().add(atbt);
                FeatureInstanceList instance_list1 = new FeatureInstanceList(fl1);
                instance_list1 = instance_list1.findInconsistentInstanceList();
                int consistent_no_of_rows = 0, inconsistent_no_of_rows = 0;
                for (int n = 0; n < instance_list1.list_of_consistent_instances.size(); n++) {
                    FeatureInstance inst1 = instance_list1.list_of_consistent_instances.get(n);
                    ArrayList<Integer> consistent_rows;
                    consistent_rows=instance_list1.getInstanceIndices(inst1);
                    consistent_no_of_rows = consistent_no_of_rows + consistent_rows.size();
                }
                for (int n = 0; n < instance_list1.list_of_inconsistent_instances.size(); n++) {
                	FeatureInstance inst2 = instance_list1.list_of_inconsistent_instances.get(n);
                    inconsistent_no_of_rows = inconsistent_no_of_rows + instance_list1.getInstanceIndices(inst2).size();
                }
           //     System.out.println("consistent_no_of_rows"+consistent_no_of_rows);
           //     System.out.println("inconsistent_no_of_rows"+inconsistent_no_of_rows);
                for (int m = 0; m < instance_list1.list_of_consistent_instances.size(); m++) 
                {
                    if (consistent_no_of_rows > highest_consistences) {
                        highest_consistences = consistent_no_of_rows;
                        predominant_attribute = atbt;
                    } else if (consistent_no_of_rows == highest_consistences) {
                        if (predominant_attribute != null) {
                            if (atbt.getFeatureRangeSize() < predominant_attribute.getFeatureRangeSize()) {
                                predominant_attribute = atbt;
                            }
                        } else {
                            predominant_attribute = atbt;
                        }

                    }
                }
             //   System.out.println(predominant_attribute.getFeatureArray());
                fl1.removeFeature(atbt);
            }
            
        }
        
   //     System.out.println(predominant_attribute.getFeatureArray());
        return predominant_attribute;
    }

    /*
     * Method to find reduct from core features.
     * Reduct is the set of features which cannot be reduced to preserve the instance consistency.
     */
    public FeatureList findReductFromCoreFeatures(FeatureList corefeatures) {
    	FeatureList reduct = new FeatureList(corefeatures.feature_array, corefeatures.target);
    	FeatureInstanceList instlist = new FeatureInstanceList(reduct);
        instlist = instlist.findInconsistentInstanceList();
        ArrayList<Integer> instance_indices_array;
        instance_indices_array = instlist.getIndicesofInstancelist(instlist.list_of_consistent_instances);
        Collections.sort(instance_indices_array);
        for (int l = instance_indices_array.size() - 1; l >= 0; l--) {
            int inst_index = instance_indices_array.get(l);
            for (int j = 0; j < this.feature_array.size(); j++) {
                this.feature_array.get(j).removeFeatureValue(inst_index);
            }
            this.target.removeFeatureValue(inst_index);
        }
        if(this.feature_array.get(0).getFeatureArraySize()==0){
            return reduct;
        }
        Feature atbt;
        int length = this.getAllFeaturesArray().size(), level = 0;
        while (level < length) {
            atbt = this.findPredominantFeature(reduct);
            if (atbt.getName() == null) {
                for (int k = 0; k < this.feature_array.size(); k++) {
                    int j;
                    for (j = 0; j < reduct.feature_array.size(); j++) {
                        if (this.feature_array.get(k).equals(reduct.feature_array.get(j).getName())) {
                            break;
                        }
                    }
                    if (j == reduct.feature_array.size()) {
                        reduct.addFeature(this.feature_array.get(k));
                        break;
                    }


                }
            }
            else {
                reduct.feature_array.add(atbt);
                FeatureInstanceList instlist2 = new FeatureInstanceList(reduct);
                instlist2 = instlist2.findInconsistentInstanceList();
                ArrayList<Integer> consistent_rows = new ArrayList<Integer>();
                for (int n = 0; n < instlist2.list_of_consistent_instances.size(); n++) {
                    FeatureInstance inst1 = instlist2.list_of_consistent_instances.get(n);
                    ArrayList<Integer> consistent_rows_local;
                    consistent_rows_local = instlist2.getInstanceIndices(inst1);
                    for (int p = 0; p < consistent_rows_local.size(); p++) {
                        consistent_rows.add(consistent_rows_local.get(p));
                    }
                }
                Collections.sort(consistent_rows);
                for (int u = consistent_rows.size() - 1; u >= 0; u--) {
                    this.removeFeatureValueatIndex(consistent_rows.get(u));
                }
            }
        if(this.feature_array.get(0).getFeatureArraySize()==0)
            break;
        level++;
        
        } return reduct;
    }

}