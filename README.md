# kubernetes-spring-rabbitmq

Producer
![image](https://user-images.githubusercontent.com/21373505/211490412-0c52327c-50ed-40e6-90c2-aa4b25326367.png)

Consumer Replica 1
![image](https://user-images.githubusercontent.com/21373505/211490465-0aa03170-b587-4db3-bb1e-4db3c9d5146c.png)

Consumer Replica 2
![image](https://user-images.githubusercontent.com/21373505/211490506-eb5541d5-9bb4-404e-b249-5c4e1f782487.png)

Consumer Replica 3
![image](https://user-images.githubusercontent.com/21373505/211490569-af05ab3f-57f1-4ebc-a209-bee42f385ff5.png)

## Jaeger deployment on Kubernetes

helm repo add my-repo [https://charts.bitnami.com/bitnami](https://charts.bitnami.com/bitnami)

helm install jaeger --namespace project my-repo/jaeger

kubectl patch svc jaeger-query -n project -p '{"spec": {"type": "NodePort"}}’

kubectl exec -it jaeger-cassandra-0 -n project bash

cqlsh -u bn_jaeger -p IJo2Tax3N1

![image](https://user-images.githubusercontent.com/21373505/211787773-193f22b4-0d17-4753-8e0a-3a890db79a74.png)
