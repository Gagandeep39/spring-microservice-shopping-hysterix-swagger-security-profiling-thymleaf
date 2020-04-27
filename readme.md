# Product Service 

### GET localhost:4004/products
Fetch all products

### GET localhost:4004/products/{id}
Fetch Products By ID

### GET localhost:4004/products/category/{category}
Fetch Products By Category

### GET localhost:4004/productdetails
Fetch All products Details

### GET localhost:4004/productdetails/{id}
Fetch Product Details By ID

### POST localhost:4004/products
Add a product 

Dummy Data

'''
{
    "stock":40,
    "productDetails": {
    	"price": 240000,
    	"name": "Predator x24",
    	"category": "Laptop"
    }
}
'''

Response 
'''
{
    "id": 6,
    "stock": 40,
    "productDetails": {
        "productId": 6,
        "price": 240000,
        "name": "Predator x24",
        "category": "Laptop"
    }
}
'''

### PUT localhost:4004/products/stock/{productId}/{quantity}

Update Stocks\

# Login Service

### GET localhost:4001

App Start point

# Cart Service 

## POST localhost:4003/shoppingcartitem/{cartId}

Add Item to cart\
All other product details data are optional\
When we only provide ID, other details might be null in response\
However proper relations are created on database\
*The response must not be used for followup operation, its only to see if data was inserted\
Request\
'''
{
	"quantity":10,
	"productDetails": {
		"productId":4
	}
}
'''
Response 
'''
{
    "cartId": 22,
    "status": "Shopping",
    "customer": {
        "id": 1,
        "password": "123456",
        "username": "gagandeep39",
        "active": 1,
        "name": "Gagandeep Singh",
        "address": "B-702 Shiv Om,near Dmart, Nahar Amrit Shakti,Chandivali, Mumbai 400072, B-702 Shiv Om Complex",
        "email": "singh.gagandeep3911@gmail.com",
        "phoneNumber": "08419969059"
    },
    "cartItems": [
        {
            "cartItemId": 9,
            "quantity": 20,
            "productDetails": {
                "productId": 4,
                "price": 50000,
                "name": "OnePlus 7 Pro",
                "category": "Mobile"
            }
        },
        {
            "cartItemId": 55,
            "quantity": 113,
            "productDetails": {
                "productId": 3,
                "price": 65000,
                "name": "Acer Predator",
                "category": "Laptop"
            }
        }
    ]
}
'''
## POST http://localhost:4003/shoppingcart/{customerId}
Fetch Latest Cart/Create new\
The respose wil contain null values except idea, this is due to atre of JpaRespository as it doesnt refresh\            
Response
'''
{
    "cartId": 27,
    "status": "Shopping",
    "customer": {
        "id": 2,
        "password": null,
        "username": null,
        "active": 0,
        "name": null,
        "address": null,
        "email": null,
        "phoneNumber": null
    },
    "cartItems": []
}
'''

## GET localhost:4003/shoppingcart/{cartId}

Fetch Cart By ID\
Response\
'''
{
    "cartId": 22,
    "status": "Shopping",
    "customer": {
        "id": 1,
        "password": "123456",
        "username": "gagandeep39",
        "active": 1,
        "name": "Gagandeep Singh",
        "address": "B-702 Shiv Om,near Dmart, Nahar Amrit Shakti,Chandivali, Mumbai 400072, B-702 Shiv Om Complex",
        "email": "singh.gagandeep3911@gmail.com",
        "phoneNumber": "08419969059"
    },
    "cartItems": [
        {
            "cartItemId": 10,
            "quantity": 10,
            "productDetails": {
                "productId": 4,
                "price": 50000,
                "name": "OnePlus 7 Pro",
                "category": "Mobile"
            }
        }
    ]
}
'''
## DELETE localhost:4003/shoppingcart/{cartId}
Delete a Cart By ID 
Response\
Success

## DELETE localhost:4003/shoppingcartitem/{cartId}/{cartItemId}
Delte an Item in cart

# Purchase Service 

## POST http://localhost:4005/purchases/{cartId}
Checkout cart with given ID

## POST localhost:4005/purchases/customer/{customerId}
Fetch Purchase History By Customer

# Swagger Docs

Woks in the given sirvies \
- Cart Service
- Prduct Service 
- Pirchase Service 

## GET http://localhost:{port}/v2/api-docs

Doccumentation in JSOn format

## GET http://localhost:{port}/swagger-ui.html

Documentation with a GUI 

# Hystrix

- NOTE: Always run page with fallback command before starting hystrix dashboard

## Dashboar URL http://localhost:4001/hystrix

## Test Hystrix on App http://localhost:4001/actuator/hystrix.stream

