import { LocationComponent } from './components/location/location.component';
import { OrdersComponent } from './components/orders/orders.component';
import { AuthGuardService } from './service/auth-guard.service';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EventsComponent } from './components/events/events/events.component';
import { EventDetailsComponent } from './components/events/event-details/event-details.component';

const routes: Routes = [
  { path: '', component: EventsComponent },
  {
    path: 'details/:id',
    component: EventDetailsComponent,
    // canActivate: [AuthGuardService],
  },
  {
    path: 'orders',
    component: OrdersComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'location',
    component: LocationComponent,
    // canActivate: [AuthGuardService],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
