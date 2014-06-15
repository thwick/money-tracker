'use strict';

/* App Module */

var budgetApp = angular.module('budgetApp', [
  'ui.router',
  'budgetControllers',
  'budgetFilters',
  'budgetServices',
  'ngGrid',
  'ui.bootstrap'
]);

budgetApp.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
	

	$stateProvider.state('home', {
		url: "",
  		templateUrl: 'partials/home.html',
  		controller: 'HomeCtrl'
	})
	
	$stateProvider.state('categories', {
        templateUrl: 'partials/category-list.html',
        controller: 'CategoryListCtrl'
	})
	
	$stateProvider.state('accounts', {
        templateUrl: 'partials/account-list.html',
        controller: 'AccountListCtrl'
	})
	
	$stateProvider.state('account', {
        templateUrl: 'partials/account-detail.html',
        controller: 'AccountListCtrl'
	})
	
	$urlRouterProvider.otherwise("/");
	
}]);


/* 
budgetApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/', {
        templateUrl: 'partials/main.html',
        controller: 'HomeCtrl'
      }).
      when('/accounts', {
        templateUrl: 'partials/account-list.html',
        controller: 'AccountListCtrl'
      }).
      when('/accounts/:accountId', {
        templateUrl: 'partials/account-detail.html',
        controller: 'AccountDetailCtrl'
      }).
      when('/categories', {
        templateUrl: 'partials/category-list.html',
        controller: 'CategoryListCtrl'
      }).
      otherwise({
        redirectTo: '/'
      });
  }]);
*/