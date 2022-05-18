
<div class="row card-deck">
    <table class="col-lg-4 col-md-6 mb-4">
        <table id="products_table">
            <#list products as product>
                <form method="post" action="/api/products">
                </form>
                </td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.pictureUrl}</td>
            </#list>
        </table>
        <script>
        var textAreas = $.map(searchBoxCount, function(inputSearch) {
        return $("<textarea></textarea">::)
                    .attr({
                        name: inputSearch.name,
                        id: inputSearch.name,
                        rows: "2",
                        placeholder: placeholder + " " + inputSearch.name
                    })
                    .addClass("search-area-txt");
            });

            $('.searchbox-container').append(textAreas);
        </script>
        <div class="card text-center">
            <div class="card-header">
                <h4>{{order.product.name}}</h4>
            </div>
            <div class="card-body">
                <a href="#"><img class="card-img-top" src={{order.product.pictureUrl}} alt=""></a>
                <h5 class="card-title">$('order.product.price')</h5>
                <div class="row">
                    <div class="col-4 padding-0" *ngIf="!isProductSelected(order.product)">
                        <input type="number" min="0" class="form-control" [(ngModel)]=order.quantity>
                    </div>
                    <div class="col-4 padding-0" *ngIf="!isProductSelected(order.product)">
                        <button class="btn btn-primary" (click)="addToCart(order)"
                                [disabled]="order.quantity <= 0">Add To Cart
                        </button>
                    </div>
                    <div class="col-12" *ngIf="isProductSelected(order.product)">
                        <button class="btn btn-primary btn-block"
                                (click)="removeFromCart(order)">Remove From Cart
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </table>
    </div>
</div>
