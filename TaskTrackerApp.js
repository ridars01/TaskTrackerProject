async function viewTasks(){
    const httpResponse = await fetch('http://localhost:8080/TaskTrackerAppOne/tasks/'); 
    const tasks = await httpResponse.json() ; 

    let tableHead = '<thead class = "table-header-row">  <th class = "table-title">Task Id#</th> <th class = "table-title"> Task </th>  <th class = "table-title">Description</th> <th class = "table-title">Priority</th>  <th class = "table-title">Done</th></thead>'; 

    let tableRows = "" ; 

    for(const task of tasks){
        tableRows +=`<tr class = "table-row-style"> <td>${task.taskId}</td> <td>${task.task}</td> <td>${task.description}</td> <td>${task.priority}</td> <td> <input type="checkbox" id="myCheck" onclick="showCheckbox()">  </td> </tr>` ;
        // onclick = "deleteTask()"
    }

    const taskTable = document.getElementById("taskTable") ; 
    taskTable.innerHTML = tableHead + tableRows ; 
}

viewTasks() ; 


async function addTask() {

    const taskVal = document.getElementById("taskInput").value; 

    const priorityVal = Number.parseInt(document.getElementById("priorityInput").value) ; 

    const descriptionVal = document.getElementById("descriptionInput").value ; 

    const task = {task:taskVal , description:descriptionVal,priority: priorityVal , taskId:0} ;

    const settings = {method: 'POST' , body:JSON.stringify(task)}

    const  httpResponse = await fetch('http://localhost:8080/TaskTrackerAppOne/tasks/' , settings) ; 

    alert('Task added !!')

    viewTasks() ; 
}

async function deleteTask(){

     const taskId = document.getElementById("deleteInput").value ; 
     console.log(taskId) ; 
     const settings = {method:'DELETE'}
     console.log(settings) ; 
    const httpResponse = await fetch(`http://localhost:8080/TaskTrackerAppOne/tasks/${taskId}` , settings) ; 
    console.log(httpResponse) ; 
    console.log("you clicked me ! ")    

    alert('Deleted Task') ; 

}




