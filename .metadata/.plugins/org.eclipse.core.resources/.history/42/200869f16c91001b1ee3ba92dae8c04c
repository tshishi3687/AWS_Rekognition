package com.amazonaws.samples;


import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.AgeRange;
import com.amazonaws.services.rekognition.model.AmazonRekognitionException;
import com.amazonaws.services.rekognition.model.Attribute;
import com.amazonaws.services.rekognition.model.DetectFacesRequest;
import com.amazonaws.services.rekognition.model.DetectFacesResult;
import com.amazonaws.services.rekognition.model.DetectLabelsRequest;
import com.amazonaws.services.rekognition.model.DetectLabelsResult;
import com.amazonaws.services.rekognition.model.FaceDetail;
import com.amazonaws.services.rekognition.model.Image;
import com.amazonaws.services.rekognition.model.Label;
import com.amazonaws.services.rekognition.model.S3Object;
import java.util.List;

public class DetectFaces {

 public static void main(String[] args) throws Exception {

    String photo = "famille.jpg";
    String bucket = "ced-test-java";


    AmazonRekognitionClientBuilder.standard();
	AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.standard().withRegion("us-east-1").build();

	DetectFacesRequest request = new DetectFacesRequest()
         .withImage(new Image()
         .withS3Object(new S3Object()
         .withName(photo)
         .withBucket(bucket)))
         .withAttributes(Attribute.ALL);

    try {
       DetectFacesResult result = rekognitionClient.detectFaces(request);
       List<FaceDetail> labels = result.getFaceDetails();

       System.out.println(labels.size() + " visages ont été détectés");
       for (FaceDetail face: labels) {
    	   if(request.getAttributes().contains("ALL")) {
    		   AgeRange ageRange = face.getAgeRange();
    		   System.out.println("le visage détecté est estimé entre "
    				   + ageRange.getLow().toString() + " et " + ageRange.getHigh().toString()
    				   + " ans");
    	   }else {
    		   System.out.println("voici l’ensemble par défaut des attributs");
    	   }
       }
    } catch(AmazonRekognitionException e) {
       e.printStackTrace();
    }
 }
}


