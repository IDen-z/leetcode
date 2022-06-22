#!/bin/bash
path=`pwd`
git fetch origin
echo 当前目录${path}项目已更新
br=`git branch | grep "*"`
cur=${br/* /}
echo 当前分支为 ${cur}
git add --all
git commit -m $1
git merge origin/${cur} ${cur}
git push origin ${cur}
echo 推送远程仓库完成！

