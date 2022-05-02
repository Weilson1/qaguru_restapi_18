import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

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
                .body("success", CoreMatchers.is(true))
                .body("message", CoreMatchers.is("The product has been added to your " +
                        "<a href=\"/cart\">shopping cart</a>"))
                .body("updatetopcartsectionhtml", CoreMatchers.is("(1)"));
    }

    @Test
    void addToWishListTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("Nop.customer=ba78fc97-1802-4fed-a5d5-ba6860f8d4bb;")
                .body("addtocart_14.EnteredQuantity=1")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/14/2")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", CoreMatchers.is(true))
                .body("updatetopwishlistsectionhtml", CoreMatchers.is("(1)"));
    }
}
