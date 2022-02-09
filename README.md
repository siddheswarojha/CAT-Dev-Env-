
# CAT (Courier Application & Tracker)

    CAT is one of the most adavnced courier tracking system. The application provides 
    users the power to track their courier and parcel in realtime using the android application.

    This application is supported by SpringBoot for the backend.

    The feature provided in the first release are:

    1. User Authentication
    2. Tracking packages
    3. Ordering Parcels
    4. Complaint and other issues



## API Reference

#### Get list of all the orders to date (Admin Specific)

```http
  GET /api/v1/cat/getTrackingDetails
```

#### Get list of specific order  (Admin & User Specific)

```http
  GET /api/v1/cat/getTrackingDetail/{orderId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `orderId`      | `long` | **Required**. Id of item to fetch |

#### save details of specific order

```http
  POST /api/v1/cat/saveTrackingDetail
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `String` | **Required**|
| `itemType`      | `String` | **Required**|
| `startLocation`      | `String` | **Required**|
| `currentLocation`      | `String` | **Required**|
| `expectedDeliveryDate`      | `String` | **Required**|
| `status`      | `String` | **Required**|
| `deliveryLocation`      | `String` | **Required**|

#### Delete an order when cancelled by user

```http
  DELETE /api/v1/cat/cancelDelivery/{orderId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `orderId`      | `long` | **Required**.  |



#### update status of an order when received by user

```http
  PUT /api/v1/cat/deliveryCompleted/{orderId}"
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `orderId`      | `long` | **Required**.  |










#### **AUTHENTICATION**


#### Register the User

```http
  POST /api/v1/cat/auth/userSignUp"
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `String` | **Required**.  |
| `emailAddress`      | `String` | **Required**.  |
| `password`      | `String` | **Required**.  |



#### Login the User

```http
  POST /api/v1/cat/auth/login"
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `emailAddress`      | `String` | **Required**.  |
| `password`      | `String` | **Required**.  |











## Contributing

Contributions are always welcome!

See `contributing.md` for ways to get started.

Please adhere to this project's `code of conduct`.


## Tech Stack

**Client:** Android Studio

**Server:** SpringBoot

**IDE** Android Studio, IntelliJ IDEA

**Other Tools** Postman,MongoDB,Firebase

