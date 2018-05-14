package test2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestHomeTest {
    @BeforeClass
    public static void setup(){
        useRelaxedHTTPSValidation();
        //RestAssured.proxy();
    }
    //@Ignore
    @Test
    public void testHtml(){

        given()
                .queryParam("q","appium")
                .when()
                            .get("https://testerhome.com/search").prettyPeek()
                .then()
                            .statusCode(200)
                            .body("html.head.title",equalTo("appium · 搜索结果 · TesterHome"));
    }

    @Test
    public void testTestHomeJson(){
        given()
                .when().get("https://testerhome.com/api/v3/topics.json").prettyPeek()
                .then().statusCode(200)
                .body("topics.title", hasItems("优质招聘汇总"))
                .body("topics.title[2]",equalTo("优质招聘汇总"))
                .body("topics.id[-1]", equalTo(13072))
                .body("topics.findAll{topics -> topics.id == 10254}.title",hasItems("优质招聘汇总"))
                .body("topics.find{topics -> topics.id == 10254}.title",equalTo("优质招聘汇总"));
    }

    @Test
    public void testTestHomeJsonSingle(){
        given().when().get("https://testerhome.com/api/v3/topics/10254.json").prettyPeek()
                .then().statusCode(200)
                .body("topic.title", equalTo("优质招聘汇总"));
               // .body("topic.findAll{topic -> topic.id  == 10254}",equalTo(10254));
    }

    @Test
    public void testTestHomeSearch(){
        given().queryParam("q","霍格沃兹测试学院")
                .when().get("https://testerhome.com/search").prettyPeek()
                .then()
                .statusCode(200);//.body("")
    }

    @Test
    public void testJsonPost(){
        //RestAssured.baseURI();
        //RestAssured.proxy();
        HashMap<String, Object> data = new HashMap<String, Object>();
         data.put("id",9999);
         data.put("title", "什么鬼东西");
         data.put("name" ,"什么");

         given().contentType(ContentType.JSON)
                    .body(data)
         .when()
                    .post("http://www.baidu.com")
                    .then().statusCode(200);





    }
}
