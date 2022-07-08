package com.investree.demo.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestingController {

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void restTemplateSave() throws Exception{
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept","*/*");
        headers.set("Content-Type","application/json");
        String body = "{\n"+
        "\"tenor\":9,\n"+
        "\"total_pinjaman\":5000000,\n"+
        "\"bunga_persen\":2.5,\n"+
        "\"status\":\"belum lunas\",\n"+
        "\"userPeminjam\":{\n"+
        "\"id\":3,\n"+
        "\"username\":\"irawan\",\n"+
        "\"password\":\"password\",\n"+
        "\"is_active\":true\n"+
                "   },\n"+
                "  \"user\":{\n "+
        "\"id\":1,\n " +
        "\"username\":\"dwiky\",\n"+
        "\"password\":\"password\",\n"+
        "\"is_active\":true\n"+
    "}"+
    "\n"+
    "}";
/*        String bodyTesting = "{\n" +
                "    \"tenor\":1,\n" +
                "    \"total_pinjaman\":1_000_000,\n" +
                "    \"bunga_persen\":2_0,\n" +
                "    \n" +
                "}";;*/
        HttpEntity<String> entity =new HttpEntity<String>(body,headers);
        ResponseEntity<String> exchange = restTemplate.exchange
                ( "http://localhost:8081/api/v1/transaksi", HttpMethod.POST,entity,String.class);
        assertEquals(HttpStatus.OK,exchange.getStatusCode());
        System.out.println("response = "+exchange.getBody());

    }
}
