package test3;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ValidatableResponse;
//import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExampleForDoubanAPI {

    @Before
    public void before() {
        useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://api.douban.com/v2/book";
        RestAssured.port = 80;
    }

    @Test
    //URL为http://api.douban.com/v2/book/1220562
    //判断Json中的返回信息title
    public void testGetBook() {
        get("/1220562").then().body("title", equalTo("满月之夜白鲸现"));
    }

    //@Test
    //URL为http://api.douban.com/v2/book/search?q=java8
    //判断Json中的返回信息关键字为“java8”的书本的数目
//    public void testSearchBook() {
//        given().param("q", "java8").when().get("/search").then().body("count", equalTo(2));
//    }

    //@Test
    //解析JSON
//    public void testParseJson() {
//        ValidatableResponse resp = get("/1220562").then();
//        //判断返回Json数据的title
//        resp.body("title", equalTo("满月之夜白鲸现"));
//        //判断二级属性rating.max的值
//        resp.body("rating.max", equalTo(10));
//        //调用数组的方法判断数组的大小
//        resp.body("tags.size()", is(8));
//        //判断数组第一个对象的值
//        resp.body("tags[0].name", equalTo("片山恭一"));
//        //判断数组中是否有该元素
//        resp.body("author", hasItems("[日] 片山恭一"));
//    }

    @After
    public void after() {
    }

}
