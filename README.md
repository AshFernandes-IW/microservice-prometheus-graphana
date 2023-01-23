# Monitoring REST APIs using Prometheus and Grafana 

#### This guide assumes you have the following installed and running:
* [Docker](https://www.docker.com/products/docker-desktop/)
* [pgAdmin4](https://www.pgadmin.org/download/)
* [Postman](https://www.postman.com/downloads/)

## Instructions 
- Clone the repository into a local directory.
- Enter ``docker-compose up --build`` in the terminal of the same directory. This build might take a few minutes to complete.
- Enter ``http://localhost:8002/`` in your web browser to access the **Kong Manager** dashboard. Scroll down and create a new workpsace by clicking on **default**.
- We will now set up the **plugins**, **services** and **routes** which can be located in the left-hand navigation panel. 
- Click **Install Plugin** and search for *Prometheus*. Tick all the boxes located under *Tags* before clicking **Install**.

Ensure the output is as follows, matching each service with its respective route name:

![services](https://github.com/AshFernandes-IW/Microservice-API-Gateway-Database/blob/master/img/service.png)
![routes](https://github.com/AshFernandes-IW/Microservice-API-Gateway-Database/blob/master/img/route.png)

**NOTE:** For the **saveCustomer** route, create a header ``Content-Type`` with ``application/json`` as the header value.

### Configuring Grafana Dashboard
- Open your web browser and enter ``localhost:3000`` to access the Grafana dashboard.
- You will be greeted with a login screen, enter the username and password you created within the ``docker-compose.yml`` file.
- Once directed to the home page, click on ``Add your first data source`` and select Prometheus. We'll set the URL to ``localhost:9090`` before selecting ``Save and test``. To confirm that things are running correctly, a green banner on the lower-half of the screen will display ``Data source is working``.
- On the left-hand navigation panel, click on ``+ Import`` which is located under the **Dashboards** tab.
- We will upload ``dashboard.JSON``, this can be found in the prometheus folder of our directory.
- Go back and select the same data source we just created before clicking ``Import``.
- We will repeat the process but this time upload ``kong-dashboard.json`` (located under same folder of directory) and this lets us monitor our Kong APIs.

### Database Confirmation with pgAdmin4
- Open pgAdmin4 and click **Add New Server**. We will call our server ``gateway-microservice``. In the **Connection** tab, set the host name/address to ``localhost`` before entering the correct username and password as found in our ``docker-compose.yml`` file under *services > db > environment*. Click **Save**.
- You can access the database on the left-hand panel under **Servers**.
Now by going to: *Databases > [Username] > Schemas > Tables > customer > Columns*, you will see the values **id**, **age**, **first_name**, **last_name**, and **sex**.

### Testing with Postman
- Import and open ``AshFernandes.postman_collection.json`` to your Postman desktop app.
1. Send the ``getCustomer`` request. You will find an empty list being returned, with status code ``200 OK``
2. Send the ``saveCustomer`` request. This will populate the list, with status code ``201 Created``
3. Send the ``getCustomer`` request again. You can view the newly populated list at the bottom half of the screen under **Body**. The status code should return ``200 OK``
4. Send the ``deleteCustomer`` request. This will delete the data from that list. Make sure you enter the correct user ID at the end of the URL (can be located from our list as given from the ``getCustomer`` request). The status code should return ``204 No Content``
5. Send the ``getCustomer`` request a final time. You can view an empty list now, with status code ``200 OK``
