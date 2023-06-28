//package com.te.allerganlms.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.ViewResolver;
//
//import net.sf.jasperreports.engine.fill.JRFiller;
//@Configuration
//public class JasperConfiguration{
//	@Autowired
//    private ApplicationContext applicationContext;
//
//    @Bean
//    public ViewResolver jasperReportsViewResolver(JasperReportsContext jasperReportsContext) {
//        JasperReportsViewResolver resolver = new JasperReportsViewResolver();
//        resolver.setPrefix("/reports/");
//        resolver.setSuffix(".jrxml");
//        resolver.setReportDataKey("jasperPrint");
//        resolver.setViewNames("*jasperView*");
//        resolver.setViewClass(JasperReportsMultiFormatView.class);
//        resolver.setOrder(0);
//
//        JRFillerFactory.getInstance(jasperReportsContext);
//        JRFiller filler = JRFillerFactory.createFiller(jasperReportsContext, JasperReportsMultiFormatView.DEFAULT_FORMAT_KEY);
//
//        resolver.setJasperReportsContext(jasperReportsContext);
//        resolver.setJasperReportsExporterKey(JasperReportsMultiFormatView.DEFAULT_FORMAT_KEY);
//        resolver.setJasperReportsFiller(filler);
//        resolver.setApplicationContext(applicationContext);
//
//        return resolver;
//    }
//}
