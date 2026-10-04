# Kafka Local Commands

## List topics

```powershell
docker exec -it kafka /opt/kafka/bin/kafka-topics.sh `
  --bootstrap-server localhost:9092 `
  --list

Create patient topic
docker exec -it kafka /opt/kafka/bin/kafka-topics.sh `
  --bootstrap-server localhost:9092 `
  --create `
  --topic patient `
  --partitions 1 `
  --replication-factor 1

Start producer
docker exec -it kafka /opt/kafka/bin/kafka-console-producer.sh `
  --bootstrap-server localhost:9092 `
  --topic patient

Check topic offsets
docker exec kafka /opt/kafka/bin/kafka-get-offsets.sh `
  --bootstrap-server localhost:9092 `
  --topic patient

Read messages from beginning
docker exec kafka /opt/kafka/bin/kafka-console-consumer.sh `
  --bootstrap-server localhost:9092 `
  --topic patient `
  --partition 0 `
  --offset earliest `
  --max-messages 2

Inspect Docker network
docker network inspect internal