import java.util.ArrayList;



public class FeatureInstance 
{

	private ArrayList<String> fvalues;
	private String target_value;
	
	public FeatureInstance()
	{
		fvalues=new ArrayList<String>();
	}
	
	//constructor to create an instance from given featurelist
	
	public FeatureInstance(int n,FeatureList fl)
	{
		fvalues=new ArrayList<String>();
		for(int i=0;i<fl.getAllFeaturesArray().size();i++)
		{
			fvalues.add(fl.getAllFeaturesArray().get(i).getFeatureArray().get(n));
		}
		if(fl.getTarget().getFeatureArray()!=null)
		{
			target_value=fl.getTarget().getFeatureArray().get(n);
		}
	}
	
	//Constructor to create an instance from a given set of features and target.
    
	public FeatureInstance(int k, ArrayList<Feature> feature_array, Feature targetvalue)
	{
        if(k<feature_array.get(0).getFeatureArraySize()){
            fvalues=new ArrayList<String>();
            for(int i=0; i<feature_array.size();i++)
                fvalues.add(feature_array.get(i).getFeatureArray().get(k));
            target_value=targetvalue.getFeatureArray().get(k);
        } 
    }
	
	//Method to create an instance from feature array and target 
    
    public FeatureInstance(ArrayList<String> feature_array, String target)
    {
        fvalues=feature_array;
        target_value=target;
    }
    
    //Method to get feature values of instance
    
    public ArrayList<String> getInstanceFValues()
    {
        return fvalues;
    }
    
    //Method to get target of instance
    
    public String getInstanceTargetValue()
    {
        return target_value;
    }
    
    //Method to check weather two instances are same. This will check only weather feature values are same.
    
    public boolean isEqual(FeatureInstance in){
        int flag=0;
        for(int l=0; l<fvalues.size();l++){
            if(!(fvalues.get(l).equals(in.fvalues.get(l))))
                    flag++;}
        if(flag==0)
            return true;
        else
            return false;
    }

    //method to check consistency of two instances
    
    public boolean isConsistent(FeatureInstance fi2)
    {
    	if(this.isEqual(fi2))
    	{
    		if(target_value.equals(fi2.target_value))
    			return true;
    		else
    			return false;
    	}
    	else 
    		return true;
    }
    
    //method for printing a featureinstance
    
    public void printFeatureInstance()
    {
    	for(int i=0;i<fvalues.size();i++)
    	{
    		System.out.println(fvalues.get(i)+",");
    	}
    	System.out.println(target_value);
    }
}
