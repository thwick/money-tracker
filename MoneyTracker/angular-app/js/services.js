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
    return $resource('/rest/api/accounts/:id', {}, {
      query: {method:'GET', isArray:false},
      save:	{method:'POST'}
    });
  }]);
  
budgetServices.factory('Category', ['$resource',
  function($resource){
    return $resource('/rest/api/categories/:id', {}, {
      query: {method:'GET', isArray:false},
      save:	{method:'POST'}
    });
  }]); 
  