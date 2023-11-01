package com.example.demo5;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.SingleThreadModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.soap.*;

import javax.xml.namespace.QName;
import java.io.IOException;

@WebServlet(name = "demoServlet", value = "/demo")
public class DemoServlet extends HttpServlet implements SingleThreadModel {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
            SOAPBody soapBody = soapEnvelope.getBody();

            SOAPElement responseElement = soapBody.addChildElement("Response");

            SOAPElement resultElement = responseElement.addChildElement("Result");

            SOAPElement detailsElement = resultElement.addChildElement("Details");

            detailsElement.addAttribute(new QName("id"), "123");

            detailsElement.setValue("Some details!");

            soapMessage.saveChanges();

            resp.setContentType("text/xml;charset=UTF-8");

            soapMessage.writeTo(resp.getOutputStream());

        } catch (SOAPException e) {

            System.out.println(e.getMessage());
        }

    }

}