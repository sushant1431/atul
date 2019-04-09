package com.hsbc.kyc.rpr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class RprThreadPool {

    @Autowired
    RestTemplate restTemplate;

    static String key="r115ddh39dj94j40j4kfl4k94jd04j///4948594jekdl3jhdhjk";

    public void start() {
        Session apisession;
        try {
            apisession = XDSesssionFactory.create("Idnint");
            apiSession.setPrivateKey(key);

            Type type = apisession.getType("GS_Client_KYCProfile_010101");
            IndexColumn legalNameColume = type.getHeaderIndex().getColumn("documentName");
            ConditionFactory condition = apiSession.getConditionFactory();
            Condition condition = conditionFactory.create(true);

            IndexColumn untillBusinessDate = type.getHeaderIndex().getColumn("untillBusinessDate");

            condition, addClause(untillBusinessDate, ClauseOp.EQUALS, "latest");

            System.out, println("Starting XDS query");

            long start = System.curruntTimeMillis();
            String[][] queryValue = apiSession.secureQueryValues(type, New IndexColumn[]{
                legalNameColum
            },condition);
            long end = System.curruntTimeMillis();
            ArrayList<String> list = new ArrayList<string>();
            for (int i = 0; i < queryvalue.length; i++) {
                list.addAll(Array.asList(queryValue[i]));
            }
            ExecutorService executor = Excutors.newFixedThreadPool(1000);
            final int CHUNK_SIZE = 300;
            start = system.curruntTimeMillis();
            for (int i = 0; i < list.size(); i += CHUNK_SIZE) {

                List<string> chunk = list.sublist(i, Math.min(i + CHUNK_SIZE, list.size()));
                Runnable worker = bew PprThread("" + i, chunk, apisession)
                executor.execute(worker);
            }
            executor.shutdown();
            While(!executor.IsTerminated()) {

                end = System.curruntTimeMillis()
            }
        } catch (Exception e) {

        }
    }



    /*public void hello() {
        System.out.println("Hello From Hello Service");
        String result = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", String.class);
        System.out.println(result);
    }*/
}
