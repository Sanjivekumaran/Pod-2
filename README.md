"# Policy Administration System (PAS) " 

## How to contribute <a name="usage"></a>

**Step 1: Fork this repository**
* A fork will create a copy of this repository in your GitHub account.
<img src="imgs\Screenshot 2021-09-30 192153.png" alt="fork howto" style="height: 100px; width: 400px;">

**Step 2: Clone the repository**
* Cloning will create the copy of the forked repository in your local machine.
* Copy the URL from here.
<img src="imgs\Screenshot 2021-09-30 193003.png" alt="clone" style="height: 300px; weight: 250px;">

* Open Git Bash or terminal and run the following command:

```
git clone https://github.com/<Your GitHub Username>/Flutter-UI.git
```

* After cloning the repo, run this command to add the [main repository](https://github.com/Project-Easter/Flutter-UI.git) as `upstream` to sync with it. Run this command to add `upstream`:

```
git remote add upstream https://github.com/Project-Easter/Flutter-UI.git
```

**Step 3: Create a branch:**
* Creating your own branch separates your changes with *main* branch. For example, if things go wrong or you are not satisfied with them, then you can delete your branch and the *main* project won't be affected.

Navigate to the folder where the repository is cloned, which will be named *Pod-2*.

Now, in the terminal, create a branch in Git using the following command:

```
git checkout -b <pod-2/your-first-name>
```

Use the same name in the branch created in GitHub.

**Step 4: Make necessary changes and commit**
1. Open the project in INTELLI-J IDEA or ECLIPSE and make sure that you are on **the branch created by you**, not on *main*.
2. Make the changes on the concerned files in order to implement a feature you want to add or resolve an issue.
3. After you are satisfied with your changes, you can add these changes by using the command:

```
git add <file names>
```

4. Pull the changes from the upstream repo using the command:

```
git pull upstream main
```

5. Then commit these changes using the command:

```
git commit -m'<Relevant commit message>'
```

**Step 5: Push changes**

Push your changes using the command:

```
git push origin <hacktober/your-first-name>
```

**Step 6: Make a Pull request**

Go to your forked GitHub repository, you will see a *Compare & pull request* button. Click on it.
<img src="imgs\Compare-Pull-Request.png" alt="make pr"
style="height:150px; width: 650px;">
