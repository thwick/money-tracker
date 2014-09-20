angular.module('budgetControllers').controller('CategoryListCtrl', ['$scope', 'Category', '$log',
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