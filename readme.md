# Product Service 

### GET localhost:4004/products

### GET localhost:4004/products/{id}

### GET localhost:4004/products/category/{category}

### GET localhost:4004/productdetails

### GET localhost:4004/productdetails/{id}

### POST localhost:4004/products
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

# Login Service

### GET localhost:4001

App Start point