package petshop.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import petshop.ProductRecommendationApplication;

@Entity
@Table(name = "RecommendedProduct_table")
@Data
//<<< DDD / Aggregate Root
public class RecommendedProduct {

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

    public static RecommendedProductRepository repository() {
        RecommendedProductRepository recommendedProductRepository = ProductRecommendationApplication.applicationContext.getBean(
            RecommendedProductRepository.class
        );
        return recommendedProductRepository;
    }

    //<<< Clean Arch / Port Method
    public static void recommend(밤12시 밤12시) {
        //implement business logic here:

        /** Example 1:  new item 
        RecommendedProduct recommendedProduct = new RecommendedProduct();
        repository().save(recommendedProduct);

        */

        /** Example 2:  finding and process
        
        repository().findById(밤12시.get???()).ifPresent(recommendedProduct->{
            
            recommendedProduct // do something
            repository().save(recommendedProduct);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
