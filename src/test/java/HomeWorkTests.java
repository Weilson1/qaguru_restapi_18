import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class HomeWorkTests {

    @Test
    void addToCartAsNewUserTests () {
        given ()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("addtocart_31.EnteredQuantity=1")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/31/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your " +
                        "<a href=\"/cart\">shopping cart</a>"))
                .body("updatetopcartsectionhtml", is("(1)"));
    }

    @Test
    void productReview() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("productReviewId=227&washelpful=true")
                .when()
                .post("http://demowebshop.tricentis.com/setproductreviewhelpfulness")
                .then()
                .log().all()
                .statusCode(200)
                .body("Result", is("Only registered customers can set review helpfulness"));
    }

    @Test
    void subscribeNewsLetterTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("email=dasd%40dasd.ru")
                .when()
                .post("http://demowebshop.tricentis.com/subscribenewsletter")
                .then()
                .log().all()
                .statusCode(200)
                .body("Success", is(true))
                .body("Result", is("Thank you for signing up! " +
                        "A verification email has been sent. " +
                        "We appreciate your interest."));
    }
}
