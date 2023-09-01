package petshop.domain;

import petshop.ProductRecommendationApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;


@Entity
@Table(name="RecommendedProduct_table")
@Data

//<<< DDD / Aggregate Root
public class RecommendedProduct  {


    
    @Id
    
    
    
    
    
    private String productType;
    
    
    
    
    private String size;
    
    
    
    
    private int age;
    
    
    
    
    private String gender;
    
    
    
    
    private String preferences;
    
    
    
    @Embedded
    private Photo photo;
    
    
    
    @Embedded
    private PetProfileId petProfileId;


    public static RecommendedProductRepository repository(){
        RecommendedProductRepository recommendedProductRepository = ProductRecommendationApplication.applicationContext.getBean(RecommendedProductRepository.class);
        return recommendedProductRepository;
    }




//<<< Clean Arch / Port Method
    public static void recommend(12OClockAtNight 12OClockAtNight){
        
        //implement business logic here:

        /** Example 1:  new item 
        RecommendedProduct recommendedProduct = new RecommendedProduct();
        repository().save(recommendedProduct);

        */

        /** Example 2:  finding and process
        
        repository().findById(12OClockAtNight.get???()).ifPresent(recommendedProduct->{
            
            recommendedProduct // do something
            repository().save(recommendedProduct);


         });
        */

        
    }
//>>> Clean Arch / Port Method


}
//>>> DDD / Aggregate Root
