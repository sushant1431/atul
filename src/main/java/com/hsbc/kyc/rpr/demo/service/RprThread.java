package com.hsbc.kyc.rpr.demo.service;

import org.springframework.boot.web.servlet.server.Session;

import java.util.List;

public class RprThread implements Runnable {
    private String command;
    private List<String> sublist;
    private Session apisession;

    public RprThread(String s, List<String> list, Session apisession) {
        this.command = s;
        this.sublist = list;
        this.apisession = apisession;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "Start command " + command);
        processCommand(apiSession);
        System.out.println(Thread.currentThread().getName() + "End.");
    }

    private void processCommand(Session apiSession) {
        try {
            // call XDX API
            for (String docName : sublist) {
                DocumentName[] names1 = new DocumentName[1];
                names1[0] = XDDocumentName.create(docName);
                DocumentIterator documenIterator = apiSession.secureBulkLoadLatest(name1);
                while (documenIterator.hasnext()) {
                    Document doc = documenIterator.nextDocument();
                    if (doc != null) {

                        // heare othere API call to get all document

                    }
                }
            }
        } catch (DocumentNameFormatException e) {
            e.printStackTrace();
        } catch (SessionException e1) {

            e1.printStackTrace();
        }
    }
}
