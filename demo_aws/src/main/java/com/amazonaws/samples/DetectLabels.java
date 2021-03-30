package com.amazonaws.samples;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.AmazonRekognitionException;
import com.amazonaws.services.rekognition.model.DetectLabelsRequest;
import com.amazonaws.services.rekognition.model.DetectLabelsResult;
import com.amazonaws.services.rekognition.model.Image;
import com.amazonaws.services.rekognition.model.Label;
import com.amazonaws.services.rekognition.model.S3Object;
import java.util.List;

public class DetectLabels {

 public static void main(String[] args) throws Exception {

    String photo = "photo2.jpg";
    String bucket = "ced-test-java";


    AmazonRekognitionClientBuilder.standard();
	AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.standard().withRegion("us-east-1").build();

    DetectLabelsRequest request = new DetectLabelsRequest()
         .withImage(new Image()
         .withS3Object(new S3Object()
         .withName(photo).withBucket(bucket)))
         .withMaxLabels(10)
         .withMinConfidence(75F);

    try {
       DetectLabelsResult result = rekognitionClient.detectLabels(request);
       List <Label> labels = result.getLabels();

       System.out.println("Detected labels for " + photo);
       
       Boolean vrai = false;
       
       for (Label label: labels) {
    	   
    	   if(label.getName().contains("Animal")) {
             	vrai = true;
             }
             
    	   
         // System.out.println(label.getName() + ": " + label.getConfidence().toString());
       }
       
       if(vrai) {
    	   System.out.println("\n CETTE IMAGE CONTIENT UN ANIMAL");
    	   System.out.println("\n alors, je peux faire ....");
       }else {
    	   
    	   System.out.println("\n Ce n'est pas ");
       }
    } catch(AmazonRekognitionException e) {
       e.printStackTrace();
    }
 }
}
