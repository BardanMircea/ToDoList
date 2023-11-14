import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Task } from '../model/Task';
import { catchError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TodoListService {
  tasksUrl: string = 'http://localhost:8080/api/tasks/';

  constructor(private http: HttpClient) {}

  getTasks(): Observable<Task[]> {
    return this.http
      .get<Task[]>(this.tasksUrl)
      .pipe(catchError(this.handleError('getTask', [])));
  }

  deleteTask(task: Task): Observable<any> {
    console.log(this.tasksUrl + task.id);
    return this.http
      .delete<Task>(this.tasksUrl + task.id)
      .pipe(catchError(this.handleError('getTask', [])));
  }

  saveTask(task: Task): Observable<any> {
    return this.http
      .post<Task>(this.tasksUrl, task)
      .pipe(catchError(this.handleError('getTask', [])));
  }

  // custom error handler method
  private handleError<T>(method = 'method', result?: T) {
    return (error: any): Observable<T> => {
      // Log the error to the console
      console.log(`${method} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
