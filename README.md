# NaspayTest
Implement Java client for Naspay REST API.

The client must accept Terminal Key and Terminal Secret as constructor arguments and implement a single method: getTransactionStatus.
The method must call GET /api/v1/transactions/{id} endpoint, process errors (if any), parse the response and return the transaction state as a string.
Implementation tests must be provided (see test data below).

API documentation: https://demo.naspay.net/docs/api/
API Token URL: https://demo.naspay.net/auth/token
API URL: https://demo.naspay.net/api/v1
Terminal Key: api-demo
Terminal Secret: test123

Test Data (transaction id -> state):
dbb46d0c4cfc4cdd9f923aa229106287 AUTHORIZED
5ce5fbd950294c4cbf3f3276e645668a DECLINED
8a0885e6526c4257ba213292a0d956b0 TIMEOUT
1261481f9625430887e155817e45ec33 COMPLETED
f33ae3006b074e649c1095ff8fb35e93 Handle 'Transaction is not found' error
