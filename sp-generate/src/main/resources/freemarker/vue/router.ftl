// 定义菜单列表
var menuList =	[
<#list cfg.tableList as t>
	{
		name: '${t.kebabName}',
		path: '/${t.kebabName}',
		component: Layout,
        meta: {
          title: '${t.tableComment}',
          icon: 'el-icon-folder-opened'
        },
		children: [
            {
                name: '${t.kebabName}-list',
                path: '${t.kebabName}-list',
                component: () => import('@/sp-views/${t.kebabName}/${t.kebabName}-list.vue'),
                meta: { title: '${t.tableComment}-列表' }
            },
            {
                name: '${t.kebabName}-add',
                path: '${t.kebabName}-add',
                component: () => import('@/sp-views/${t.kebabName}/${t.kebabName}-add.vue'),
                meta: { title: '${t.tableComment}-新增' }
            },
            {
                name: '${t.kebabName}-info',
                path: '${t.kebabName}-info',
                component: () => import('@/sp-views/${t.kebabName}/${t.kebabName}-info.vue'),
                meta: { title: '${t.tableComment}-详情' }
            },
		]
	},
</#list>
]