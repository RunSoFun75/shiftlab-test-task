## 1. How to build a project
+ Клонировать репозиторий и собрать проект с помощью **Maven**
+ [Скачать](https://drive.google.com/file/d/1Szr24EX7Gy4YssEUvXJ62qQy5l2bFeai/view?usp=sharing) (`OnlineElectronicStore-0.0.1-SNAPSHOT.jar`) созданный **jar-файл** и запустить

## 2. Instruments
+ Spring Web
+ Spring Data Jpa
+ Lombok
+ In memory database h2

## 3. Usage

+ Протестировать сервис можно с помощью программы [**Postman**](https://www.postman.com/)

#### Response Codes

```
200: Ok
201: Created
400: Bad Request
404: Not Found
405: Method Not Allowed
```
### Add product
+ В своем проекте я сделал допущение, что каждая техника с серийным номером должна быть уникальна, и свойство "количество единиц продукции на складе" подсчитывается автоматически для каждого типа техники исходя из того какое количество типа техники находится в базе данных
--------------
#### Add computer

`POST http://localhost:8080/store/products/computers`

+ форм-фактор может быть только следующих видов: "DESKTOP", "NETTOP", ""MONOBLOCK

##### Request Body:

```json
{
    "serialNumber": "C910-X",
    "producer": "Huawei", 
    "price": 40000, 
    "formFactor": "DESKTOP"
}
```
##### Successful Response:
**Status:** `201`
```json
{
    "id" : 1,
    "serialNumber": "C910-X",
    "producer": "Huawei", 
    "price": 40000,
    "quantityInStorage" : 1,
    "formFactor": "DESKTOP"
}
```
##### Failed Response:
***Status:*** `400`

#### Add hardDrive
`POST http://localhost:8080/store/products/hardDrives`
##### Request Body:

```json
{
    "serialNumber": "X019-Y",
    "producer": "Corsair", 
    "price": 8000, 
    "capacity": "256GB"
}
```
##### Successful Response:
***Status:*** `201`
```json
{
    "id" : 2,
    "serialNumber": "X019-Y",
    "producer": "Corsair", 
    "price": 8000,
    "quantityInStorage" : 1,
    "capacity": "256GB"
}
```
##### Failed Response:
**Status:** `400`

#### Add Laptop
`POST http://localhost:8080/store/products/laptops`
##### Request Body:

```json
{
    "serialNumber": "H13X-V",
    "producer": "Honor", 
    "price": 80000, 
    "diagonal": 15
}
```
##### Successful Response:
**Status:** `201`
```json
{
    "id" : 3,
    "serialNumber": "H13X-V",
    "producer": "Honor", 
    "price": 80000, 
    "quantityInStorage" : 1,
    "diagonal": 15
}
```
##### Failed Response:
**Status:** `400`

#### Add Monitor
`POST http://localhost:8080/store/products/monitors`
##### Request Body:

```json
{
    "serialNumber": "YY2E-X",
    "producer": "MSI", 
    "price": 100000, 
    "diagonal": 23.5
}
```
##### Successful Response:
**Status:** `201`
```json
{
    "id" : 4,
    "serialNumber": "YY2E-X",
    "producer": "MSI", 
    "price": 100000, 
    "quantityInStorage" : 1,
    "diagonal": 23.5
}
```
##### Failed Response:
**Status:** `400`

------------------

### Edit product

------------------

#### Edit computer
`PUT http://localhost:8080/store/products/computer/{id}/edit`

+ Каждый продукт независимо от типа техники имеет свой уникальный id

##### Request Body:

```json
{
    "serialNumber": "C910-X",
    "producer": "Huawei", 
    "price": 40000, 
    "formFactor": "NETTOP"
}
```
##### Successful Response:
**Status:** `200`
```json
{
    "id" : 1,
    "serialNumber": "C910-X",
    "producer": "Huawei", 
    "price": 40000, 
    "quantityInStorage" : 1,
    "formFactor": "NETTOP"
}
```
##### Failed Response:
**Status:** `404`

#### Edit hardDrive
`PUT http://localhost:8080/store/products/hardDrive/{id}/edit`

+ Каждый продукт независимо от типа техники имеет свой уникальный id

##### Request Body:

```json
{
    "serialNumber": "X019-Y",
    "producer": "Corsair",  
    "price": 8000, 
    "capacity": "1000GB"
}
```
##### Successful Response:
**Status:** `200`
```json
{
    "id" : 2,
    "serialNumber": "X019-Y",
    "producer": "Corsair",  
    "price": 8000, 
    "quantityInStorage" : 1,
    "capacity": "1000GB"
}
```
##### Failed Response:
**Status:** `404`

#### Edit Laptop
`PUT http://localhost:8080/store/products/laptop/{id}/edit`

+ Каждый продукт независимо от типа техники имеет свой уникальный id

##### Request Body:

```json
{
    "serialNumber": "H13X-V",
    "producer": "Honor", 
    "price": 80000, 
    "diagonal": 17
}
```
##### Successful Response:
**Status:** `200`
```json
{
    "id" : 3,
    "serialNumber": "H13X-V",
    "producer": "Honor", 
    "price": 80000, 
    "quantityInStorage" : 1,
    "diagonal": 17
}
```
##### Failed Response:
**Status:** `404`

#### Edit Monitor
`PUT http://localhost:8080/store/products/monitor/{id}/edit`

+ Каждый продукт независимо от типа техники имеет свой уникальный id

##### Request Body:

```json
{
    "serialNumber": "YY2E-X",
    "producer": "MSI", 
    "price": 100000, 
    "diagonal": 25
}
```
##### Successful Response:
**Status:** `200`
```json
{
    "id" : 4,
    "serialNumber": "YY2E-X",
    "producer": "MSI", 
    "price": 100000, 
    "quantityInStorage" : 1,
    "diagonal": 25
}
```
##### Failed Response:
**Status:** `404`

-------------------------
### Get products by type
-------------------------

#### Get computers
`GET http://localhost:8080/store/products/computers`

##### Request Body:

```json
{
    
}
```
##### Successful Response:
**Status:** `200`

```json
{
    "id" : 1,
    "serialNumber": "C910-X",
    "producer": "Huawei", 
    "price": 40000, 
    "quantityInStorage" : 1,
    "formFactor": "NETTOP"
}
```
##### Failed Response:
**Status:** `404`

#### Get hardDrives
`GET http://localhost:8080/store/products/hardDrives`

##### Request Body:

```json
{
    
}
```

##### Successful Response:

**Status:** `200`
```json
{
    "id" : 2,
    "serialNumber": "X019-Y",
    "producer": "Corsair",  
    "price": 8000, 
    "quantityInStorage" : 1,
    "capacity": "1000GB"
}
```
##### Failed Response:
**Status:** `404`

#### Get laptops
`GET http://localhost:8080/store/products/laptops`

##### Request Body:

```json
{
    
}
```

##### Successful Response:

**Status:** `200`
```json
{
    "id" : 3,
    "serialNumber": "H13X-V",
    "producer": "Honor", 
    "price": 80000, 
    "quantityInStorage" : 1,
    "diagonal": 17
}
```
##### Failed Response:
**Status:** `404`

#### Get monitors
`GET http://localhost:8080/store/products/monitors`

##### Request Body:

```json
{
    
}
```

##### Successful Response:

**Status:** `200`
```json
{
    "id" : 4,
    "serialNumber": "YY2E-X",
    "producer": "MSI", 
    "price": 100000, 
    "quantityInStorage" : 1,
    "diagonal": 25
}
```
##### Failed Response:
**Status:** `404`

-------------------
### Get product by id
-------------------
#### Get computer by id
`GET http://localhost:8080/store/products/computer/{id}`

##### Request Body:

```json
{
    
}
```
##### Successful Response:
**Status:** `200`

```json
{
    "id" : 1,
    "serialNumber": "C910-X",
    "producer": "Huawei", 
    "price": 40000, 
    "quantityInStorage" : 1,
    "formFactor": "NETTOP"
}
```
##### Failed Response:
**Status:** `404`

#### Get hardDrive by id
`GET http://localhost:8080/store/products/hardDrive/{id}`

##### Request Body:

```json
{
    
}
```

##### Successful Response:

**Status:** `200`
```json
{
    "id" : 2,
    "serialNumber": "X019-Y",
    "producer": "Corsair",  
    "price": 8000, 
    "quantityInStorage" : 1,
    "capacity": "1000GB"
}
```
##### Failed Response:
**Status:** `404`

#### Get laptop by id
`GET http://localhost:8080/store/products/laptop/{id}`

##### Request Body:

```json
{
    
}
```

##### Successful Response:

**Status:** `200`
```json
{
    "id" : 3,
    "serialNumber": "H13X-V",
    "producer": "Honor", 
    "price": 80000, 
    "quantityInStorage" : 1,
    "diagonal": 17
}
```
##### Failed Response:
**Status:** `404`

#### Get monitor by id
`GET http://localhost:8080/store/products/monitor/{id}`

##### Request Body:

```json
{
    
}
```

##### Successful Response:

**Status:** `200`
```json
{
    "id" : 4,
    "serialNumber": "YY2E-X",
    "producer": "MSI", 
    "price": 100000, 
    "quantityInStorage" : 1,
    "diagonal": 25
}
```
##### Failed Response:
**Status:** `404`

## 4.Author 
**Базаров Андрей**

**Gmail**: a.bazarov1@g.nsu.ru

**Telegram**: https://t.me/RunSoFun

