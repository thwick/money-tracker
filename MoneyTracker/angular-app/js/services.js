'use strict';

/* Services */

var budgetServices = angular.module('budgetServices', ['ngResource']);

  
budgetServices.factory('Home', ['$resource',
  function($resource){
    return $resource('/rest/api/accounts/:id', {}, {
      query: {method:'GET', isArray:false}
    });
  }]);
  
budgetServices.factory('Account', ['$resource',
  function($resource){
    return $resource('/rest/api/accounts/:id', {id:'@id'}, {
      query: {method:'GET', isArray:false},
      save:	{method:'POST'}
    });
  }]);
  
budgetServices.factory('Category', ['$resource',
  function($resource){
    return $resource('/rest/api/categories/:id', {id:'@id'}, {
      query: {method:'GET', isArray:false},
      save:	{method:'POST'}
    });
  }]); 
  
budgetServices.factory('AccountTransaction', ['$resource',
  function($resource){
    return $resource('/rest/api/accounts/:id/transactions ', {id:'@id'}, {
      query: {method:'GET', isArray:false},
      save:	{method:'POST'}
    });
  }]);

budgetServices.factory('AccountTransactionBalance', ['$resource',
  function($resource){
    return $resource('/rest/api/accounts/:id/balance', {id:'@id'}, {
      query: {method:'GET', isArray:false}
    });
  }]);
  
    
budgetServices.factory('Transaction', ['$resource',
  function($resource){
    return $resource('/rest/api/transactions/:id ', {id:'@id'}, {
      query: {method:'GET', isArray:false},
      save:	{method:'POST'}
    });
}]);  