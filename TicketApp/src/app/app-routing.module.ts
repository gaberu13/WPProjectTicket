import { TicketAdminComponent } from './components/admin/ticket-admin/ticket-admin.component';
import { CategoryAdminComponent } from './components/admin/category-admin/category-admin.component';
import { EventAdminComponent } from './components/admin/event-admin/event-admin.component';
import { AdminPanelComponent } from './components/admin/admin-panel/admin-panel.component';
import { AboutComponent } from './components/about/about.component';
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
  },
  {
    path: 'orders',
    component: OrdersComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'location',
    component: LocationComponent,
  },
  {
    path: 'about',
    component: AboutComponent,
  },
  {
    path: 'admin',
    component: AdminPanelComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'admin/event',
    component: EventAdminComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'admin/category',
    component: CategoryAdminComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'admin/ticket',
    component: TicketAdminComponent,
    canActivate: [AuthGuardService],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
