Pet project для изучения kafka.

Стэк:
Java 17
h2 DB
Spring Boot
Spring JPA
Lombock
junit
Kafka

В проекте две сущности:
Contract - договор, который в простом виде описывает сущность договор, в представлении банка.
Transactions - транкзация. Содержит сумму, дату проведения, id Contract. Связана с сущностью Contract связью ManyToOne.

ContractConsumer - подписан на событие, в котором получит сообщение ContractEvent.
ContractEvent содержит даты start, end, contract.
Делается запрос в БД, к сущности Transactions, в котором найдет сумму всех транказаций по номеру договора в переделах дат start, end.
В результате SumProducer отправит сообщение SumDto, которое содержит сумму.