package com.example.WuzzufDataAnalysisJavaEE;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class WuzzufDataAnalysisBinder extends AbstractBinder
{
    @Override
    protected void configure()
    {
        bind(DataHandler.class).to(DataHandler.class);
    }
}