angular.module('budgetControllers').controller('AccountRegisterCtrl', ['$scope', 'Account', 'AccountTransaction', 'Transaction',
									'Category', 'AccountTransactionBalance', '$log', '$stateParams',
  function($scope, Account, AccountTransaction, Transaction, Category, AccountTransactionBalance, $log, $stateParams) {
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
	    $scope.transactions = AccountTransaction.query({},{'id': $stateParams.id});
		$scope.gridOptions = { data: 'transactions.transaction' };
    }
    
    $scope.balance = AccountTransactionBalance.query({},{'id': $stateParams.id});

  }]);
