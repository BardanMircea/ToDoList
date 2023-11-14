import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { TodoListComponent } from './component/todo-list/todo-list.component';
import { TodoListService } from './service/todo-list.service';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [AppComponent, TodoListComponent],
  imports: [FormsModule, HttpClientModule, BrowserModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
