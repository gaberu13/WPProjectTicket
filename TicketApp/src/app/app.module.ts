import { LoaderService } from './service/loader.service';
import { AuthenticationModule } from './authentication/authentication.module';

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EventsComponent } from './components/events/events/events.component';
import { EventCarouselComponent } from './components/event-carousel/event-carousel.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ScrollTopComponent } from './components/scroll-top/scroll-top.component';
import { EventDetailsComponent } from './components/events/event-details/event-details.component';
import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { HttpInterceotorService } from './service/http-interceotor.service';
import { OrdersComponent } from './components/orders/orders.component';
import { LoaderComponent } from './components/loader/loader.component';
import { LocationComponent } from './components/location/location.component';
import { NoitemfoundComponent } from './components/noitemfound/noitemfound.component';
import { FooterComponent } from './components/footer/footer.component';
import { UserTypeDirective } from './directives/user-type.directive';
import { EditLocationComponent } from './components/edit-location/edit-location.component';
import { AboutComponent } from './components/about/about.component';
import { AdminPanelComponent } from './components/admin/admin-panel/admin-panel.component';
import { EventAdminComponent } from './components/admin/event-admin/event-admin.component';
import { CategoryAdminComponent } from './components/admin/category-admin/category-admin.component';
import { TicketAdminComponent } from './components/admin/ticket-admin/ticket-admin.component';
import { UpdateEventAdminComponent } from './components/admin/update-event-admin/update-event-admin.component';
import { ConfirmDialogComponent } from './components/confirm-dialog/confirm-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    EventsComponent,
    EventCarouselComponent,
    ScrollTopComponent,
    EventDetailsComponent,
    ShoppingCartComponent,
    CheckoutComponent,
    OrdersComponent,
    LoaderComponent,
    LocationComponent,
    NoitemfoundComponent,
    FooterComponent,
    UserTypeDirective,
    EditLocationComponent,
    AboutComponent,
    AdminPanelComponent,
    EventAdminComponent,
    CategoryAdminComponent,
    TicketAdminComponent,
    UpdateEventAdminComponent,
    ConfirmDialogComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    BrowserAnimationsModule,
    NgbModule,
    AuthenticationModule,
  ],
  providers: [
    LoaderService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceotorService,
      multi: true,
    }
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
