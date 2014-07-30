'use strict';

/* Controllers */

var budgetControllers = angular.module('budgetControllers', []);

budgetControllers.controller('HomeCtrl', ['$scope', 'Home',
  function($scope, Home) {
    $scope.accounts = Home.query();
  }
]);
  
budgetControllers.controller('AccountListCtrl', ['$scope', 'Account', '$log',
  function($scope, Account, $log) {
  	
    $scope.accounts = Account.query();
    $scope.selectedItems = [];
	$scope.gridOptions = { data: 'accounts.account', 
							selectedItems: $scope.selectedItems,
							multiSelect: false,
							enableSorting: true,
							enableCellEdit: false,
							columnDefs: [
								{field:"id", displayName:"Edit", 
									cellTemplate: "<div ui-sref='account({ id: {{row.getProperty(col.field)}} })'><img src='img/pencil.png'/></div>" },
									                   
						        {field:"accountName", displayName:"Name"},
						        {field:"description", displayName:"Description"},
						        {field:"retirement", displayName:"Retirement"}
						    ]
	};

	
    $scope.update = function() {
   	 	Account.save([], $scope.account, function(value, responseHeaders) {
   	 		$scope.refresh();
   	 	})
    }
    
    $scope.$on('ngGridEventEndCellEdit', function(evt){
	    console.log(evt.targetScope.row.entity);  
	    Account.save([], evt.targetScope.row.entity);
	});

    $scope.delete = function() {
    	var ids = [];
    	for (var i = 0; i < $scope.selectedItems.length; i++) {
    		var id = $scope.selectedItems[i].id;
    		console.log(id);
    		Account.delete({ id: id });
    	}
		$scope.refresh
    }
    
    $scope.refresh = function() {
	    $scope.accounts = Account.query();
		$scope.gridOptions = { data: 'accounts.account' };
    }
    
  }]);

budgetControllers.controller('AccountRegisterCtrl', ['$scope', 'Account', 'AccountTransaction', 'Transaction',
									'Category', '$log', '$stateParams',
  function($scope, Account, AccountTransaction, Transaction, Category, $log, $stateParams) {
    $scope.id = $stateParams.id;
    
    $scope.dateOptions = {
	    formatYear: 'yy',
	    startingDay: 1
	  };
  
  $scope.open = function($event) {
    $event.preventDefault();
    $event.stopPropagation();

    $scope.opened = true;
  };
  
    $scope.categories = Category.query();
    
    $scope.account = Account.get({},{'id': $stateParams.id});
    	
	$scope.transactions = AccountTransaction.query({},{'id': $stateParams.id});
    
	$scope.gridOptions = { data: 'transactions.transaction', 
							showSelectionCheckbox: true,  
							enableSorting: true,
							enableCellEditOnFocus: true,
							enableCellEdit:true,
      						enableCellSelection:true,
							columnDefs: [
						        {field:"id", displayName:"Id"},
						        {field:"transactionDt", displayName:"Date"},
						        {field:"category.categoryName", displayName:"Category"},
						        {field:"description", displayName:"Description"},
						        {field:"amount", displayName:"Amount"}
						    ]
	};
	
	 $scope.saveTransaction = function() {
	 	$scope.newTransaction.accountId = $stateParams.id;
	 	$scope.newTransaction.categoryId = $scope.selectedCategory.id;
   	 	Transaction.save([], $scope.newTransaction, function(value, responseHeaders) {
   	 		$scope.refresh();
   	 	})
    }
    
   $scope.refresh = function() {
	    $scope.accounts = Account.query();
		$scope.gridOptions = { data: 'accounts.account' };
    }
  }]);

 
budgetControllers.controller('CategoryListCtrl', ['$scope', 'Category', '$log',
  function($scope, Category, $log) {
  	
    $scope.categories = Category.query();
    
    $scope.selectedItems = [];
	$scope.gridOptions = { data: 'categories.category', 
							showSelectionCheckbox: true,  
							selectedItems: $scope.selectedItems,
							enableSorting: true,
							columnDefs: [
						        {field:"categoryName", displayName:"Name"},
						        {field:"id", displayName:"ID"}
						    ]
	};
	
    $scope.update = function() {
   	 	Category.save([], $scope.category, function(value, responseHeaders) {
   	 		$scope.refresh();
   	 	})
    }
    
    $scope.delete = function() {
    	var ids = [];
    	for (var i = 0; i < $scope.selectedItems.length; i++) {
    		var id = $scope.selectedItems[i].id;
    		console.log(id);
    		Category.delete({ id: id });
    	}
		$scope.refresh
    }
    
    $scope.refresh = function() {
	    $scope.categories = Category.query();
		$scope.gridOptions = { data: 'categories.category' };
    }
    
  }]);