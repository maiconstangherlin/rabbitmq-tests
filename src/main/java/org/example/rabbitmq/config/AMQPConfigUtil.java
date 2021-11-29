package org.example.rabbitmq.config;

public class AMQPConfigUtil {

    public static final String EXCHANGE_NAME = "Cards";
    public static final String MARKETING_QUEUE = "marketing-cards-created";
    public static final String FINANCE_QUEUE = "finance-cards-created";
    public static final String ALL_QUEUE = "all-cards-created";
    public static final String ROUTING_KEY = "";
    public static final String MARKETING_ROUTING_KEY = "queue.marketing";
    public static final String FINANCE_ROUTING_KEY = "queue.finance";
    public static final String ALL_ROUTING_KEY = "queue.*";

}
