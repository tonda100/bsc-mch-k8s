# BSC MCH K8S
This is example application to demonstrate rolling updates between differen versions of an application.
The repository contains:
- Java EE application with a Info endpoint
- kubernetes configuration files - k8s folder
- Dockerfile - to create docker image out of the repository

## Requirements
- prepared Kubernetes Cluster - [kops](https://github.com/kubernetes/kops/blob/master/docs/aws.md) for AWS can be used
- kubectl - command line tool for managing Kubernetes cluster

## Commands
Commands should be run from k8s folder.
#### Deploying R4
```
kubectl create -f mch-deployment-r4.yaml
kubectl create -f mch-service.yaml
```
#### Rolling update to R5
```
kubectl create -f mch-deployment-r5.yaml
kubectl scale --replicas=2 -f mch-deployment-r4.yaml
kubectl scale --replicas=2 -f mch-deployment-r5.yaml
kubectl scale --replicas=1 -f mch-deployment-r4.yaml
kubectl scale --replicas=3 -f mch-deployment-r5.yaml
kubectl scale --replicas=0 -f mch-deployment-r4.yaml
```
#### Delete
```
kubectl delete -f mch-deployment-r4.yaml
kubectl delete -f mch-service.yaml
kubectl delete -f mch-deployment-r5.yaml
```