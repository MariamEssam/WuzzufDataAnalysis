package com.example.WuzzufDataAnalysisJavaEE;

import org.glassfish.jersey.server.ResourceConfig;
public class AppConfig extends ResourceConfig
{
    public AppConfig()
    {
        packages("com.example");
        register(new WuzzufDataAnalysisBinder());
    }
}
