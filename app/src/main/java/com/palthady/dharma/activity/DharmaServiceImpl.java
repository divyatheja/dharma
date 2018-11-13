package com.palthady.dharma.activity;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;

import java.io.IOException;

import com.palthady.dharma.activity.entity.Admin;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;

public class DharmaServiceImpl {
    HttpClient httpClient = new DefaultHttpClient();
    HttpContext localContext = new BasicHttpContext();

    public Admin  getAuthenticated(String phoneNumber) throws JSONException {

    HttpGet httpGet = new HttpGet("https://demodt.herokuapp.com/authourizeMobile?phoneNumber="+phoneNumber);
        HttpResponse response = null;
        Admin admin = new Admin();
        try {
            response = httpClient.execute(httpGet, localContext);
            ObjectMapper objectMapper = new ObjectMapper();
            admin = objectMapper.readValue(response.getEntity().getContent(),Admin.class);
            /*if (admin!=null){




                System.out.println("PPPPPPPPPPPPPPPPPPPP"+admin.getName());

                return admin;
            }*/
        } catch (IOException e1) {

        }

        System.out.println("PPPPPPPPPPPPPPPPPPPP"+admin.getName());
     //   text = getASCIIContentFromEntity(entity);
    return admin;

    }
}