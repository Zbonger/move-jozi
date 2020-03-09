import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class LoadModule {
  id: number;
  createdDate: string;
  modifiedDate: string;
  summary: string;
  description: string;
  jobType: string;
  fromDestination: string;
  toDestination: string;
  company: string;
  address: string;
  userId: number;
  startBiddingPrice: number;
}
