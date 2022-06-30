import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateConsumerComponent } from './consumer/create-consumer/create-consumer.component';
import { UpdateConsumerComponent } from './consumer/update-consumer/update-consumer.component';
import { ViewConsumerComponent } from './consumer/view-consumer/view-consumer.component';
import { CreatePolicyComponent } from './policy/create-policy/create-policy.component';
import { IssuePolicyComponent } from './policy/issue-policy/issue-policy.component';
import { ViewPolicyComponent } from './policy/view-policy/view-policy.component';

const routes: Routes = [
  { path: 'viewConsumer/:id', component: ViewConsumerComponent },
  { path: 'createConsumer', component: CreateConsumerComponent },
  { path: 'updateConsumer', component: UpdateConsumerComponent },
  { path: 'createPolicy', component: CreatePolicyComponent },
  { path: 'issuePolicy', component: IssuePolicyComponent },
  { path: 'viewPolicy/:id', component: ViewPolicyComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
