import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Test {

	public static void main(String args[]) throws IOException
	{
		File f=new File("bridges.csv");
		FeatureList fl=new FeatureList(f);
	//	System.out.println("attbt size is ="+fl.getTarget().getFeatureArraySize());
	//	System.out.println("size "+fl.getAllFeaturesArray().size());
		FeatureList fli;
	//fli=fl.removeJunk();
	//	System.out.println("size "+fli.getAllFeaturesArray().size());

		fli=fl.removeDuplicateFeatures();
        fli=fl.findCoreFeatures();
      //  fl.findPredominantFeature(fli);
        FeatureList min_reduct = fl.findReductFromCoreFeatures(fli);
        System.out.println("the size of min reduct attributes is " + min_reduct.getAllFeaturesArray().size());
 
     /*   System.out.println("size "+fli.getAllFeaturesArray().size());
        System.out.println("size "+fli.getAllFeaturesArray().get(0).getFeatureArray());
        System.out.println("size "+fli.getAllFeaturesArray().get(1).getFeatureArray());
        System.out.println("size "+fli.getAllFeaturesArray().get(2).getFeatureArray());
        System.out.println("size "+fli.getAllFeaturesArray().get(3).getFeatureArray());
	*/
	}
}
