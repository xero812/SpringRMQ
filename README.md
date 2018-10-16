# SpringRMQ

Integration of Rabbit Messaging Queue with Spring.

## Prerequisites

Install RabbitMQ from (http://rabbitmq.com/download.html).

It should be running on `localhost` on port `5672`|`15672`.

## Tools

Spring Boot 2.0.5.RELEASE.

JDK 1.8.0.

Apache Maven 3.5.2.

Spring AMQP Core 2.0.5.RELEASE.

JUL to SLF4J Bridge 1.7.25. (Optional)

Log4j Implemented Over SLF4J 1.7.25. (Optional)

## How to Start

After establishing the Rabbit MQ connection, you can just use 
```mvn spring-boot:run``` to start the application.

## Sending Messages

Use this `POST` request to send the messages.

```
curl -X POST \
  http://localhost:8080/message \
  -H 'accept: application/json' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{
    "id": "2",
    "data": "Hello, World!",
    "actions":"PRIORITY_0"
}
'
```

## Receiving Messages

```
curl -X GET \
  http://localhost:8080/message \
  -H 'accept: application/json' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json'
  ```
