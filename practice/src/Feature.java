import java.util.ArrayList;

/*Feature class vth featurevalues and featurerange
featurevalues are values of a particular feature
featurerange is the range of featurevalues in vch der are no duplicate values
*/

public class Feature {

	private String fname;
	private ArrayList<String> feature_values;
	private ArrayList<String> feature_range;
	
	public Feature()
	{
		feature_values=new ArrayList<String>();
		feature_range=new ArrayList<String>();
	}
	
	//constructr vth feature name and the values 
	public Feature(String fname,ArrayList<String> featurearray)
	{
		feature_values=new ArrayList<String>();
		feature_range=new ArrayList<String>();
		for(int i=0;i<featurearray.size();i++)
		{
			this.feature_values.add(featurearray.get(i));
			
			if(!feature_range.contains(featurearray.get(i)))
			{
				feature_range.add(featurearray.get(i));
			}
		}
				
	}
	
	 
    //Method to remove feature value from feature by taking value string as input.
    public void removeFeatureValue(String featurevalue){
        this.feature_values.remove(featurevalue);
    }
    
    //Method to remove an feature value from feature by taking index as input. 
    public void removeFeatureValue(int featurevalueindex){
        this.feature_values.remove(featurevalueindex);
    }
    
    //Method to get feature value at specified index. 
    public String getFeatureValue(int featurevalueindex){
        return this.feature_values.get(featurevalueindex);
    }
    
    //Method to add an feature value to the feature by taking value string as input
    public void addFeatureValue(String featurevalue){
        this.feature_values.add(featurevalue);
    }
    
     //Method to add an feature value to the feature by taking value string  and index as inputs
    public void addFeatureValue(int featurevalueindex, String featurevalue){
        this.feature_values.add(featurevalueindex,featurevalue);
    }
    
    //Method to set the name of the attribute.
    public void setName(String name){
        this.fname=name;
    }
 
    
    
    //Method to set the feature values by taking Array List of values.
    public void setFeatureArray(ArrayList<String> features){
        if(this.feature_values==null)
            this.feature_values=new ArrayList<String>();
        if(this.feature_range==null)
            this.feature_range=new ArrayList<String>();
        for(int i=0; i<features.size();i++){
            this.feature_values.add(features.get(i));
            if(!this.feature_range.contains(features.get(i)))
                this.feature_range.add(features.get(i));
        }
    }
    
    //Method to check weather two feature are same.
    public boolean equals(Feature f){
        if(this.feature_values.equals(f.feature_values))
                return true;
        else
            return false;
    }
    
    //Method to get the name of the feature
    public String getName(){
        return this.fname;
    }
    
    //Method to get the size of feature.
    public int getFeatureArraySize(){
        return this.feature_values.size();
    }
    
    //Method to get the size of the range of values of feature
     public int getFeatureRangeSize(){
        return this.feature_range.size();
    }
     
    //Method to get the feature values.
    public ArrayList<String> getFeatureArray(){
        return this.feature_values;
    }
    
    
    //Method to get the range of feature values
    public ArrayList<String> getFeatureRange(){
        return this.feature_range;
    }
}
