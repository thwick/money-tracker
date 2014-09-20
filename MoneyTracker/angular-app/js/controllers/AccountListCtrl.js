angular.module('budgetControllers').controller('AccountListCtrl', ['$scope', 'Account', '$log', '$modal',
  function($scope, Account, $log, $modal) {
  	
    $scope.accounts = Account.query();
    $scope.selectedItems = [];
	$scope.gridOptions = { data: 'accounts.account', 
							selectedItems: $scope.selectedItems,
							multiSelect: false,
							enableSorting: true,
							enableCellEdit: false,
							columnDefs: [
								{field:"id", displayName:"Edit", 
									cellTemplate: "<div ui-sref='account({ id: {{row.getProperty(col.field)}} })'><img src='img/edit.png'/></div>" },
						        {field:"id", displayName:"Delete", 
									cellTemplate: "<button class='btn btn-default' ng-click='openDeleteModal(row)'>Delete</button>" },
						        {field:"accountName", displayName:"Name", width: 200},
						        {field:"description", displayName:"Description"},
						        {field:"retirement", displayName:"Retirement", width: 100}
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
    
    $scope.openDeleteModal = function (row) {

	    var ModalInstanceCtrl = function ($scope, $modalInstance, items) {
		
		    $scope.ok = function () {
		        Account.delete({ id: $scope.id });
		    	$modalInstance.close();
		  	};
		
		    $scope.cancel = function () {
		      $modalInstance.dismiss('cancel');
	    };
	    
	    var modalInstance = $modal.open({
	      templateUrl: 'modal-dialog.html',
	      controller: ModalInstanceCtrl,
	      id: row.getProperty('id'),
	      resolve: {
	        items: function () {
	          return $scope.items;
	        }
	      }
	    });
	
	    modalInstance.result.then(function (selectedItem) {
	      $scope.selected = selectedItem;
	    }, function () {
	      $log.info('Modal dismissed at: ' + new Date());
	    });
	    

	};
	
	};
  
}]);
