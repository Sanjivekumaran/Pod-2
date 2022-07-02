import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateComponent } from './consumer/create/create.component';
import { UpdateConsumerComponent } from './consumer/update-consumer/update-consumer.component';
import { CreateConsumerComponent } from './consumer/create-consumer/create-consumer.component';
import { ViewConsumerComponent } from './consumer/view-consumer/view-consumer.component';
import { CreatePolicyComponent } from './policy/create-policy/create-policy.component';
import { ViewPolicyComponent } from './policy/view-policy/view-policy.component';
import { IssuePolicyComponent } from './policy/issue-policy/issue-policy.component';
import { PolicyComponent } from './policy/policy/policy.component';
import { ConsumerComponent } from './consumer/consumer/consumer.component';

@NgModule({
  declarations: [AppComponent, CreateComponent, UpdateConsumerComponent, CreateConsumerComponent, ViewConsumerComponent, CreatePolicyComponent, ViewPolicyComponent, IssuePolicyComponent, PolicyComponent, ConsumerComponent],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
